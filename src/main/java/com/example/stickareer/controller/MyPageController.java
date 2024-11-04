package com.example.stickareer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.example.stickareer.service.UserService;
import com.example.stickareer.dto.PersonalDataResponse;

@RestController
@RequestMapping("/data/Mypage")
@RequiredArgsConstructor
public class MyPageController {
    private final UserService userService;

    @GetMapping("/personalData")
    public ResponseEntity<PersonalDataResponse> getPersonalData(@AuthenticationPrincipal UserDetails userDetails) {
        PersonalDataResponse response = userService.getPersonalData(userDetails.getUsername());
        return ResponseEntity.ok(response);
    }
} 