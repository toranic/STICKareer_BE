package com.example.stickareer.oauth2;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OAuth2TokenResponse {
    private String accessToken;
    private String tokenType;
    private String refreshToken;
    private Long expiresIn;
} 