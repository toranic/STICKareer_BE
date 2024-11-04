package com.example.stickareer.service;

import com.example.stickareer.dto.CommunityDetailResponseDto;
import com.example.stickareer.dto.CommunityDetailRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.stickareer.repository.CommunityRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final CommunityRepository communityRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CommunityDetailResponseDto getPost(Long postId) {
        try {
            Resource resource = new ClassPathResource("static/data/Community/dummypost.json");
            return objectMapper.readValue(resource.getInputStream(), CommunityDetailResponseDto.class);
        } catch (IOException e) {
            throw new RuntimeException("게시글 데이터를 불러오는데 실패했습니다.", e);
        }
    }

    public CommunityDetailResponseDto createPost(CommunityDetailRequestDto requestDto, String username) {
        // 게시물 생성 로직 구현
        return null; // 실제 구현에서는 적절한 응답 반환
    }

    public List<CommunityDetailResponseDto> getAllPosts() {
        return communityRepository.findAll().stream()
                .map(CommunityDetailResponseDto::from)
                .collect(Collectors.toList());
    }
}
 