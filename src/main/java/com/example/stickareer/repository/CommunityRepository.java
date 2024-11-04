package com.example.stickareer.repository;

import com.example.stickareer.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Integer> {
    List<Community> findByHashtag_Id(Integer hashtagId);
    List<Community> findByUsername(String username);
    List<Community> findByTitleContaining(String keyword);
} 