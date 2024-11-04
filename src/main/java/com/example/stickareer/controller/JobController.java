package com.example.stickareer.controller;

import com.example.stickareer.dto.JobInfoResponse;
import com.example.stickareer.service.JobInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobInfoService jobInfoService;

    @GetMapping("/search")
    public ResponseEntity<List<JobInfoResponse>> searchJobs(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String location) {
        return ResponseEntity.ok(jobInfoService.searchJobs(keyword, location));
    }
} 