package com.example.stickareer.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.stickareer.entity.Comment;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {
    private String author;
    private String content;
    private String date;

    public CommentDto(Comment comment) {
        this.author = comment.getAuthor();
        this.content = comment.getContent();
        this.date = comment.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
} 