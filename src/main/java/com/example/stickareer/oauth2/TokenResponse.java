package com.example.stickareer.oauth2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenResponse {
    @JsonProperty("access_token")
    private String accessToken;
}