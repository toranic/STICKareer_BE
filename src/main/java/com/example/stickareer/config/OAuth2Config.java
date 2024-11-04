package com.example.stickareer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.stickareer.oauth2.OAuth2Client;

@Configuration
public class OAuth2Config {

    @Bean
    public OAuth2Client oAuth2Client() {
        return OAuth2Client.builder()
                .clientId("your-client-id")
                .clientSecret("your-client-secret")
                .build();
    }
} 