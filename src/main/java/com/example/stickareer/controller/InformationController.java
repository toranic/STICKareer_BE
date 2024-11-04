package com.example.stickareer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.stickareer.service.InformationService;
import com.example.stickareer.dto.InformationResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/information")
@RequiredArgsConstructor
public class InformationController {
    private final InformationService informationService;

    @GetMapping
    public ResponseEntity<List<InformationResponseDto>> getInformations(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "default") String type) {
        return ResponseEntity.ok(informationService.getInformations(search, type));
    }
} 