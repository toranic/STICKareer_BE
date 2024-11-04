package com.example.stickareer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HashtagResponseDto {
    private Integer id;
    private String title;
    private String detail;
} 