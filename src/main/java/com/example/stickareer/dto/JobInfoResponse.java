package com.example.stickareer.dto;

import com.example.stickareer.entity.JobInfo;
import lombok.Getter;
import java.time.LocalDateTime;
import lombok.Builder;

@Getter
@Builder
public class JobInfoResponse {
    private Integer companyId;
    private Integer hashtagId;
    private String name;
    private String location;
    private String field;
    private String task;
    private String description;
    private LocalDateTime dateApplyStart;
    private LocalDateTime dateApplyEnd;

    public static JobInfoResponse from(JobInfo jobInfo) {
        return JobInfoResponse.builder()
                .companyId(jobInfo.getCompanyId())
                .hashtagId(jobInfo.getHashtagId())
                .name(jobInfo.getName())
                .location(jobInfo.getLocation())
                .field(jobInfo.getField())
                .task(jobInfo.getTask())
                .description(jobInfo.getDescription())
                .dateApplyStart(jobInfo.getDateApplyStart())
                .dateApplyEnd(jobInfo.getDateApplyEnd())
                .build();
    }
} 