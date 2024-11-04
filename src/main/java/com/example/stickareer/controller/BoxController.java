package com.example.stickareer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.stickareer.service.BoxService;
import com.example.stickareer.dto.BoxDTO;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class BoxController {
    
    @Autowired
    private BoxService boxService;
    
    @GetMapping("/boxes")
    public ResponseEntity<List<BoxDTO>> getAllBoxes() {
        List<BoxDTO> boxes = boxService.getAllBoxes();
        return ResponseEntity.ok(boxes);
    }
} 