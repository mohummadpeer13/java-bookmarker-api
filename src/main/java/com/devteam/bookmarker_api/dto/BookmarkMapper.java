package com.devteam.bookmarker_api.dto;

import org.springframework.stereotype.Component;

import com.devteam.bookmarker_api.entity.Bookmark;

@Component
public class BookmarkMapper {
    public BookmarkDTO toDTO(Bookmark bookmark){
        return new BookmarkDTO(
        bookmark.getId(),
        bookmark.getTitle(),
        bookmark.getUrl(),
        bookmark.getCreatedAt(),
        bookmark.getDescription()
        );
    }
}
