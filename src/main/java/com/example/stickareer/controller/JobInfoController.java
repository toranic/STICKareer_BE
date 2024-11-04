package com.example.stickareer.controller;

import com.example.stickareer.dto.JobInfoRequest;
import com.example.stickareer.dto.JobInfoResponse;
import com.example.stickareer.service.JobInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobInfoController {
    private final JobInfoService jobInfoService;

    @GetMapping("/{companyId}")
    public ResponseEntity<JobInfoResponse> getJob(@PathVariable Integer companyId) {
        return ResponseEntity.ok(jobInfoService.getJob(companyId));
    }

    @PostMapping("/{companyId}")
    public ResponseEntity<JobInfoResponse> createJob(
            @PathVariable Integer companyId,
            @RequestBody JobInfoRequest request) {
        return ResponseEntity.ok(jobInfoService.createJob(companyId, request));
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<JobInfoResponse> updateJob(
            @PathVariable Integer companyId,
            @RequestBody JobInfoRequest request) {
        return ResponseEntity.ok(jobInfoService.updateJob(companyId, request));
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteJob(@PathVariable Integer companyId) {
        jobInfoService.deleteJob(companyId);
        return ResponseEntity.noContent().build();
    }
} 