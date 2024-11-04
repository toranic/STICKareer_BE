package com.example.stickareer.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;
import com.example.stickareer.repository.BookmarkRepository;
import com.example.stickareer.dto.BookmarkResponse;
import com.example.stickareer.entity.User;
import com.example.stickareer.entity.Bookmark;
import com.example.stickareer.dto.BookmarkRequest;
import com.example.stickareer.repository.CommunityRepository;
import com.example.stickareer.exception.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final UserService userService;
    private final CommunityRepository communityRepository;

    public List<BookmarkResponse> getUserBookmarks() {
        User currentUser = userService.getCurrentUser();
        List<Bookmark> bookmarks = bookmarkRepository.findAllByUserId(currentUser.getId());
        
        return bookmarks.stream()
                .<BookmarkResponse>map(bookmark -> BookmarkResponse.builder()
                        .id(bookmark.getId())
                        .postId(bookmark.getCommunity().getPostId().longValue())
                        .postTitle(bookmark.getCommunity().getTitle())
                        .createdAt(bookmark.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    public BookmarkResponse addBookmark(BookmarkRequest request) {
        Bookmark bookmark = bookmarkRepository.save(
            Bookmark.builder()
                .user(userService.getCurrentUser())
                .community(communityRepository.findById(request.getContentId())
                    .orElseThrow(() -> new EntityNotFoundException("Community not found")))
                .build()
        );
        return BookmarkResponse.builder()
                .id(bookmark.getId())
                .postId(bookmark.getCommunity().getPostId().longValue())
                .postTitle(bookmark.getCommunity().getTitle())
                .createdAt(bookmark.getCreatedAt())
                .build();
    }

    public void deleteBookmark(Long id) {
        Bookmark bookmark = bookmarkRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Bookmark not found"));
            
        // 현재 사용자가 북마크의 소유자인지 확인
        User currentUser = userService.getCurrentUser();
        if (!bookmark.getUser().getId().equals(currentUser.getId())) {
            throw new IllegalStateException("권한이 없습니다");
        }
        
        bookmarkRepository.deleteById(id);
    }
} 