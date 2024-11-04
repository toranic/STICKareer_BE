package com.example.stickareer.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import com.example.stickareer.entity.Information;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InformationResponseDto {
    private Long id;
    private String title;
    private String detail;
    private String type;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    
    public static InformationResponseDto from(Information information) {
        return InformationResponseDto.builder()
            .id(information.getId())
            .title(information.getTitle())
            .detail(information.getDetail())
            .type(information.getType())
            .startDate(information.getStartDate())
            .endDate(information.getEndDate())
            .build();
    }
} 