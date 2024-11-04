package com.example.stickareer.dto;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.stickareer.entity.Community;

@Getter
@Setter
@NoArgsConstructor
public class CommunityResponseDto {
    private Integer postno;
    private String title;
    private String content;
    private String author;
    private String date;
    private List<CommentDto> comment;

    public CommunityResponseDto(Community community) {
        this.postno = community.getPostId();
        this.title = community.getTitle();
        this.content = community.getContent();
        this.author = community.getUsername();
        this.date = community.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.comment = community.getComments().stream()
            .map(CommentDto::new)
            .collect(Collectors.toList());
    }
} 