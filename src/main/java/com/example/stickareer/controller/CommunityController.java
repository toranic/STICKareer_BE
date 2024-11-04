package com.example.stickareer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.stickareer.dto.CommunityDetailRequestDto;
import com.example.stickareer.dto.CommunityDetailResponseDto;
import com.example.stickareer.service.CommunityService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CommunityController {
    private final CommunityService communityService;

    @PostMapping("/post")
    public ResponseEntity<CommunityDetailResponseDto> createPost(
            @RequestBody CommunityDetailRequestDto requestDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        CommunityDetailResponseDto response = communityService.createPost(requestDto, userDetails.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CommunityDetailResponseDto>> getAllPosts() {
        List<CommunityDetailResponseDto> posts = communityService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<CommunityDetailResponseDto> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(communityService.getPost(postId));
    }
} 