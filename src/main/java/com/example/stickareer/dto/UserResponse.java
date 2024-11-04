package com.example.stickareer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.example.stickareer.entity.User;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class UserResponse {
    private UUID userId;
    private String email;
    private String name;
    private String phoneNum;

    @Builder
    public UserResponse(UUID userId, String email, String name, String phoneNum) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .name(user.getName())
                .phoneNum(user.getPhoneNum())
                .build();
    }
} 