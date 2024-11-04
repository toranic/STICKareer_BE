package com.example.stickareer.service;

import com.example.stickareer.dto.ExamInfoResponse;
import com.example.stickareer.entity.ExamInfo;
import com.example.stickareer.repository.ExamInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExamInfoService {
    private final ExamInfoRepository examInfoRepository;

    public ExamInfoResponse getExam(Integer examId) {
        ExamInfo examInfo = examInfoRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));
        return ExamInfoResponse.from(examInfo);
    }

    public List<ExamInfoResponse> getAllExams() {
        return examInfoRepository.findAll().stream()
                .map(ExamInfoResponse::from)
                .collect(Collectors.toList());
    }
} 