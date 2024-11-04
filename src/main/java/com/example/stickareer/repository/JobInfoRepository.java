package com.example.stickareer.repository;

import com.example.stickareer.entity.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobInfoRepository extends JpaRepository<JobInfo, Integer> {
} 