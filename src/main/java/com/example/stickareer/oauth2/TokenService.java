package com.example.stickareer.oauth2;

import com.example.stickareer.oauth2.TokenResponse;

public interface TokenService {
    TokenResponse reissueAccessToken(String authorizationHeader);
}
