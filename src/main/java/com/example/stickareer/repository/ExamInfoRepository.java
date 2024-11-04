package com.example.stickareer.repository;

import com.example.stickareer.entity.ExamInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamInfoRepository extends JpaRepository<ExamInfo, Integer> {
} 