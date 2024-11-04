package com.example.stickareer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.stickareer.repository.UserRepository;
import com.example.stickareer.dto.UserSignupRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import com.example.stickareer.entity.User;
import com.example.stickareer.exception.BusinessException;
import com.example.stickareer.dto.UserResponse;
import com.example.stickareer.oauth2.OAuth2Client;
import com.example.stickareer.oauth2.OAuth2TokenResponse;
import com.example.stickareer.oauth2.OAuth2UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.example.stickareer.dto.PersonalDataResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final OAuth2Client oauth2Client;
    
    @Transactional
    public Long signup(UserSignupRequest request) {
        validateDuplicateEmail(request.getEmail());
        
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .provider("local")
                .providerId(request.getEmail())
                .userId(UUID.randomUUID())
                .build();
                
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
    private void validateDuplicateEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new BusinessException("이미 가입된 이메일입니다.");
        }
    }
    public UserResponse getMyInfo(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return UserResponse.from(user);
    }

    public String getOAuth2LoginUrl(String provider) {
        // OAuth2 제공자에 따른 로그인 URL 생성 로직
        return switch (provider.toLowerCase()) {
            case "google" -> "https://accounts.google.com/o/oauth2/v2/auth?...";
            case "kakao" -> "https://kauth.kakao.com/oauth/authorize?...";
            // 다른 제공자들...
            default -> throw new IllegalArgumentException("지원하지 않는 OAuth2 제공자입니다: " + provider);
        };
    }

    @Transactional
    public UserResponse processOAuth2Login(String code, String state) {
        // 1. 인증 코드로 액세스 토큰 획득
        OAuth2TokenResponse tokenResponse = oauth2Client.getToken(code);
        
        // 2. 액세스 토큰으로 사용자 정보 조회
        OAuth2UserInfo userInfo = oauth2Client.getUserInfo(tokenResponse.getAccessToken());
        
        // 3. 사용자 정보로 회원가입 또는 로그인 처리
        String userEmail = userInfo.getProviderId() + "@" + userInfo.getProvider();
        User user = userRepository.findByEmail(userEmail)
            .orElseGet(() -> createOAuth2User(userInfo));
            
        return UserResponse.from(user);
    }
    
    private User createOAuth2User(OAuth2UserInfo userInfo) {
        String userEmail = userInfo.getProviderId() + "@" + userInfo.getProvider();
        User user = User.builder()
            .email(userEmail)
            .name(userInfo.getName())
            .provider(userInfo.getProvider())
            .providerId(userInfo.getProviderId())
            .build();
            
        return userRepository.save(user);
    }

    public PersonalDataResponse getPersonalData(String username) {
        PersonalDataResponse response = new PersonalDataResponse();
        response.setUsername(username);
        return response;
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByEmail(authentication.getName())
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
} 