package com.example.stickareer.dto;

import lombok.Getter;
import lombok.Builder;
import java.time.LocalDateTime;

@Getter
@Builder
public class BookmarkResponse {
    private Long id;
    private Long postId;
    private String postTitle;
    private LocalDateTime createdAt;
} 