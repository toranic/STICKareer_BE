package com.example.stickareer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import com.example.stickareer.repository.UserRepository;
import com.example.stickareer.entity.User;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauth2User = super.loadUser(userRequest);

        String provider = userRequest.getClientRegistration().getRegistrationId();
        String providerId = oauth2User.getAttribute("sub");  // Google의 경우
        String email = oauth2User.getAttribute("email");

        // 사용자 정보 저장 또는 업데이트
        User user = userRepository.findByEmail(email)
            .map(existingUser -> updateUser(existingUser, oauth2User))
            .orElseGet(() -> createUser(oauth2User, provider, providerId));

        return new DefaultOAuth2User(
            Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
            oauth2User.getAttributes(),
            "email"  // nameAttributeKey
        );
    }

    private User updateUser(User existingUser, OAuth2User oauth2User) {
        existingUser.updateFromOAuth2User(oauth2User);
        return userRepository.save(existingUser);
    }

    private User createUser(OAuth2User oauth2User, String provider, String providerId) {
        User user = User.builder()
                .email(oauth2User.getAttribute("email"))
                .provider(provider)
                .providerId(providerId)
                .build();
        return userRepository.save(user);
    }
} 