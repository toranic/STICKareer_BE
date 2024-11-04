package com.example.stickareer.repository;

import com.example.stickareer.entity.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobInfoRepository extends JpaRepository<JobInfo, Integer> {
    @Query("SELECT j FROM JobInfo j WHERE " +
           "(:keyword IS NULL OR LOWER(j.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(j.field) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(j.task) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
           "AND (:location IS NULL OR LOWER(j.location) LIKE LOWER(CONCAT('%', :location, '%')))")
    List<JobInfo> searchJobs(@Param("keyword") String keyword, @Param("location") String location);
} 