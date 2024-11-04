package com.example.stickareer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class JobInfoRequest {
    private Integer hashtagId;
    private String name;
    private String location;
    private String field;
    private String task;
    private String description;
    private LocalDateTime dateApplyStart;
    private LocalDateTime dateApplyEnd;
} 