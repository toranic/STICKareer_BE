package com.example.stickareer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignupRequest {
    private String email;
    private String name;
    private String password;
    private String phoneNum;
    private Boolean alarm;
} 