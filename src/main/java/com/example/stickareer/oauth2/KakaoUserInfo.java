package com.example.stickareer.oauth2;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class KakaoUserInfo implements OAuth2UserInfo {

    private Map<String, Object> attributes;

    @Override
    public String getProviderId() {
        // Long 타입이기 때문에 toString으로 변환
        return attributes.get("id").toString();
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getName() {
        @SuppressWarnings("unchecked")
        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
        return (String) properties.get("nickname");
    }
}