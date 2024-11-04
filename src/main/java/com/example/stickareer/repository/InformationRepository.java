package com.example.stickareer.repository;

import com.example.stickareer.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {
    List<Information> findByTitleContainingAndType(String title, String type);
    List<Information> findByTitleContaining(String title);
    List<Information> findByType(String type);
} 