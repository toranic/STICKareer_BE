package com.example.stickareer.controller;

import com.example.stickareer.dto.ExamInfoResponse;
import com.example.stickareer.service.ExamInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@RequiredArgsConstructor
public class ExamInfoController {
    private final ExamInfoService examInfoService;

    @GetMapping("/{examId}")
    public ResponseEntity<ExamInfoResponse> getExam(@PathVariable Integer examId) {
        return ResponseEntity.ok(examInfoService.getExam(examId));
    }

    @GetMapping
    public ResponseEntity<List<ExamInfoResponse>> getAllExams() {
        return ResponseEntity.ok(examInfoService.getAllExams());
    }
} 