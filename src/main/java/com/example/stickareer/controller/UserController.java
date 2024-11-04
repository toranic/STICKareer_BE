package com.example.stickareer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.stickareer.service.UserService;
import com.example.stickareer.dto.UserSignupRequest;
import com.example.stickareer.dto.UserResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getMyInfo(@AuthenticationPrincipal UserDetails userDetails) {
        UserResponse response = userService.getMyInfo(userDetails.getUsername());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/oauth2/login/{provider}")
    public ResponseEntity<String> oauth2Login(@PathVariable String provider) {
        return ResponseEntity.ok(userService.getOAuth2LoginUrl(provider));
    }

    @GetMapping("/oauth2/callback")
    public ResponseEntity<UserResponse> oauth2Callback(
        @RequestParam String code,
        @RequestParam String state
    ) {
        return ResponseEntity.ok(userService.processOAuth2Login(code, state));
    }
} 