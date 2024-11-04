package com.example.stickareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stickareer.entity.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {
} 