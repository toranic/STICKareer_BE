package com.example.stickareer.service;

import com.example.stickareer.dto.JobInfoRequest;
import com.example.stickareer.dto.JobInfoResponse;
import com.example.stickareer.entity.JobInfo;
import com.example.stickareer.repository.JobInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobInfoService {

    private final JobInfoRepository jobInfoRepository;

    public JobInfoResponse getJob(Integer companyId) {
        JobInfo jobInfo = jobInfoRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        return JobInfoResponse.from(jobInfo);
    }

    public JobInfoResponse createJob(Integer companyId, JobInfoRequest request) {
        JobInfo jobInfo = JobInfo.builder()
                .companyId(companyId)
                .hashtagId(request.getHashtagId())
                .name(request.getName())
                .location(request.getLocation())
                .field(request.getField())
                .task(request.getTask())
                .description(request.getDescription())
                .dateApplyStart(request.getDateApplyStart())
                .dateApplyEnd(request.getDateApplyEnd())
                .build();
                
        return JobInfoResponse.from(jobInfoRepository.save(jobInfo));
    }

    public JobInfoResponse updateJob(Integer companyId, JobInfoRequest request) {
        JobInfo jobInfo = jobInfoRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
                
        JobInfo updatedJobInfo = JobInfo.builder()
                .companyId(companyId)
                .hashtagId(request.getHashtagId())
                .name(request.getName())
                .location(request.getLocation())
                .field(request.getField())
                .task(request.getTask())
                .description(request.getDescription())
                .dateApplyStart(request.getDateApplyStart())
                .dateApplyEnd(request.getDateApplyEnd())
                .build();
                
        return JobInfoResponse.from(jobInfoRepository.save(updatedJobInfo));
    }

    public void deleteJob(Integer companyId) {
        jobInfoRepository.deleteById(companyId);
    }
} 