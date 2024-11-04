package com.example.stickareer.service;

import com.example.stickareer.dto.BoxDTO;
import com.example.stickareer.entity.Box;
import com.example.stickareer.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoxService {
    
    @Autowired
    private BoxRepository boxRepository;
    
    public List<BoxDTO> getAllBoxes() {
        List<Box> boxes = boxRepository.findAll();
        return boxes.stream()
                   .map(box -> new BoxDTO(
                       box.getId(),
                       box.getTitle(),
                       box.getDescription(),
                       box.getIcon()
                   ))
                   .collect(Collectors.toList());
    }
} 