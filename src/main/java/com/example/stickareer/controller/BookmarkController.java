package com.example.stickareer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.stickareer.service.BookmarkService;
import com.example.stickareer.dto.BookmarkResponse;
import com.example.stickareer.dto.BookmarkRequest;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @GetMapping
    public List<BookmarkResponse> getBookmarks() {
        return bookmarkService.getUserBookmarks();
    }

    @PostMapping
    public BookmarkResponse addBookmark(@RequestBody BookmarkRequest request) {
        return bookmarkService.addBookmark(request);
    }

    @DeleteMapping("/{id}")
    public void deleteBookmark(@PathVariable Long id) {
        bookmarkService.deleteBookmark(id);
    }
} 