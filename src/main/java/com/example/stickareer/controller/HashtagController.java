package com.example.stickareer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.stickareer.service.HashtagService;
import com.example.stickareer.dto.HashtagResponseDto;

@RestController
@RequestMapping("/api/hashtags")
@RequiredArgsConstructor
public class HashtagController {
    private final HashtagService hashtagService;

    @GetMapping
    public ResponseEntity<List<HashtagResponseDto>> getAllHashtags() {
        return ResponseEntity.ok(hashtagService.getAllHashtags());
    }

    @GetMapping("/interests")
    public ResponseEntity<List<HashtagResponseDto>> getHashtagsByInterests(
            @RequestParam List<String> interests) {
        return ResponseEntity.ok(hashtagService.getHashtagsByInterests(interests));
    }

    @GetMapping("/search")
    public ResponseEntity<List<HashtagResponseDto>> searchHashtags(
            @RequestParam String keyword) {
        return ResponseEntity.ok(hashtagService.searchHashtags(keyword));
    }
} 