package com.example.stickareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.stickareer.entity.Hashtag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HashtagRepository extends JpaRepository<Hashtag, Integer> {
    List<Hashtag> findByNameIn(List<String> interests);
    
    @Query("SELECT h FROM Hashtag h WHERE LOWER(h.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Hashtag> searchByKeyword(@Param("keyword") String keyword);
} 