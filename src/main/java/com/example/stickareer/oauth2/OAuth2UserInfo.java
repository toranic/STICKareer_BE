package com.example.stickareer.oauth2;


public interface OAuth2UserInfo {
    String getProviderId();
    String getProvider();
    String getName();
    // ... 기타 필요한 필드들
} 