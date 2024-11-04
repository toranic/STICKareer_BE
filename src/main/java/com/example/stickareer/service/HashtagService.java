package com.example.stickareer.service;

import com.example.stickareer.dto.HashtagResponseDto;
import com.example.stickareer.entity.Hashtag;
import com.example.stickareer.repository.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HashtagService {
    private final HashtagRepository hashtagRepository;

    public List<HashtagResponseDto> getAllHashtags() {
        return hashtagRepository.findAll().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    public List<HashtagResponseDto> getHashtagsByInterests(List<String> interests) {
        return hashtagRepository.findByNameIn(interests).stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    public List<HashtagResponseDto> searchHashtags(String keyword) {
        return hashtagRepository.searchByKeyword(keyword).stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    private HashtagResponseDto convertToDto(Hashtag hashtag) {
        return HashtagResponseDto.builder()
            .id(hashtag.getId())
            .title(hashtag.getName())
            .build();
    }
} 