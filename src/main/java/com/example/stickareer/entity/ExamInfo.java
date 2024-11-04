package com.example.stickareer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Builder;
import java.time.LocalDateTime;

@Entity
@Table(name = "exam_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExamInfo {
    @Id
    @Column(name = "exam_ID")
    private Integer examId;

    @Column(length = 20)
    private String title;

    @Column(length = 20)
    private String type;

    @Column(name = "date_apply_start")
    private LocalDateTime dateApplyStart;

    @Column(name = "date_apply_end")
    private LocalDateTime dateApplyEnd;

    @Builder
    public ExamInfo(Integer examId, String title, String type, 
                   LocalDateTime dateApplyStart, LocalDateTime dateApplyEnd) {
        this.examId = examId;
        this.title = title;
        this.type = type;
        this.dateApplyStart = dateApplyStart;
        this.dateApplyEnd = dateApplyEnd;
    }
} 