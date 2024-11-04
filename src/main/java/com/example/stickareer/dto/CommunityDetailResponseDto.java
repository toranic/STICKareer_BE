package com.example.stickareer.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import com.example.stickareer.entity.Community;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityDetailResponseDto {
    private Integer postId;
    private String username;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int viewCount;
    private int commentCount;
    private List<CommentDto> comments;

    public static CommunityDetailResponseDto from(Community community) {
        return CommunityDetailResponseDto.builder()
                .postId(community.getPostId())
                .title(community.getTitle())
                .content(community.getContent())
                // ... 필요한 다른 필드들 매핑
                .build();
    }
} 