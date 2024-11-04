package com.example.stickareer.oauth2;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Builder
@RequiredArgsConstructor
public class OAuth2Client {
    private final String clientId;
    private final String clientSecret;
    private final String tokenUrl;
    private final String userInfoUrl;
    private final String provider;    // OAuth 제공자 (예: "google", "kakao" 등)
    private final RestTemplate restTemplate;

    public OAuth2TokenResponse getToken(String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(clientId, clientSecret);
        
        String requestBody = String.format(
            "grant_type=authorization_code&code=%s&client_id=%s&client_secret=%s",
            code, clientId, clientSecret
        );

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<OAuth2TokenResponse> response = restTemplate.postForEntity(
            tokenUrl,
            request,
            OAuth2TokenResponse.class
        );

        return response.getBody();
    }

    public OAuth2UserInfo getUserInfo(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        
        HttpEntity<?> entity = new HttpEntity<>(headers);
        
        // 제공자별 구체적인 구현체를 반환하도록 설정
        Class<? extends OAuth2UserInfo> userInfoClass = determineUserInfoClass();
        
        ResponseEntity<? extends OAuth2UserInfo> response = restTemplate.exchange(
            userInfoUrl,
            HttpMethod.GET,
            entity,
            userInfoClass
        );

        return response.getBody();
    }
    
    private Class<? extends OAuth2UserInfo> determineUserInfoClass() {
        // 제공자별로 적절한 구현체 클래스 반환
        // 예시: GoogleOAuth2UserInfo, KakaoOAuth2UserInfo 등
        throw new UnsupportedOperationException(
            "Provider " + provider + " not implemented yet"
        );
    }
} 