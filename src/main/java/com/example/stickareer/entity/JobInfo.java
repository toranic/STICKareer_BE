package com.example.stickareer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import java.time.LocalDateTime;
import lombok.Builder;

@Entity
@Table(name = "job_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobInfo {
    @Id
    @Column(name = "company_ID")
    private Integer companyId;

    @Column(name = "hashtag_ID", nullable = false)
    private Integer hashtagId;

    @Column(length = 30)
    private String name;

    @Column(length = 100)
    private String location;

    @Column(length = 20)
    private String field;

    @Column(length = 20)
    private String task;

    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "date_apply_start")
    private LocalDateTime dateApplyStart;
    
    @Column(name = "date_apply_end")
    private LocalDateTime dateApplyEnd;

    @Builder
    public JobInfo(Integer companyId, Integer hashtagId, String name, String location, 
                  String field, String task, String description, 
                  LocalDateTime dateApplyStart, LocalDateTime dateApplyEnd) {
        this.companyId = companyId;
        this.hashtagId = hashtagId;
        this.name = name;
        this.location = location;
        this.field = field;
        this.task = task;
        this.description = description;
        this.dateApplyStart = dateApplyStart;
        this.dateApplyEnd = dateApplyEnd;
    }
} 