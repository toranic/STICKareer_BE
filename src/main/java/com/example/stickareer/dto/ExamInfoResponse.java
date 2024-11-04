package com.example.stickareer.dto;

import com.example.stickareer.entity.ExamInfo;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
public class ExamInfoResponse {
    private Integer examId;
    private String title;
    private String type;
    private LocalDateTime dateApplyStart;
    private LocalDateTime dateApplyEnd;

    public static ExamInfoResponse from(ExamInfo examInfo) {
        return ExamInfoResponse.builder()
                .examId(examInfo.getExamId())
                .title(examInfo.getTitle())
                .type(examInfo.getType())
                .dateApplyStart(examInfo.getDateApplyStart())
                .dateApplyEnd(examInfo.getDateApplyEnd())
                .build();
    }
} 