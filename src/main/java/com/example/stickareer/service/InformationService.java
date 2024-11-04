package com.example.stickareer.service;

import com.example.stickareer.dto.InformationResponseDto;
import com.example.stickareer.entity.Information;
import com.example.stickareer.repository.InformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InformationService {
    private final InformationRepository informationRepository;

    public List<InformationResponseDto> getInformations(String searchValue, String type) {
        List<Information> informations;
        
        if (searchValue.isEmpty() && type.equals("default")) {
            informations = informationRepository.findAll();
        } else if (!searchValue.isEmpty() && type.equals("default")) {
            informations = informationRepository.findByTitleContaining(searchValue);
        } else if (searchValue.isEmpty() && !type.equals("default")) {
            informations = informationRepository.findByType(type);
        } else {
            informations = informationRepository.findByTitleContainingAndType(searchValue, type);
        }
        
        return informations.stream()
                .map(InformationResponseDto::from)
                .collect(Collectors.toList());
    }
} 