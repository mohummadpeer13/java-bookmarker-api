package com.devteam.bookmarker_api.service;

import org.springframework.data.domain.Pageable;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devteam.bookmarker_api.dto.AddBookmarkDTO;
import com.devteam.bookmarker_api.dto.BookmarkDTO;
import com.devteam.bookmarker_api.dto.BookmarkMapper;
import com.devteam.bookmarker_api.dto.BookmarksDTO;
import com.devteam.bookmarker_api.entity.Bookmark;
import com.devteam.bookmarker_api.repository.BookmarkRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final BookmarkMapper bookmarkMapper;

    @Transactional(readOnly = true)
    public BookmarksDTO findAllBookmarks(Integer page) {
        // init page N°
        int pageNo = page < 1 ? 0 : page - 1;
        
        // config pageable size per page, sort by field
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.ASC, "title");

        // list bookmark pageable 
        Page<BookmarkDTO> bookmarkPage = this.bookmarkRepository.findBookmarks(pageable);
        
        return new BookmarksDTO(bookmarkPage);
    }

    @Transactional(readOnly = true)
    public BookmarksDTO searchBookmarks(String query, Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.ASC, "title");
        
        // on peut soit utiliser une requete sql personnalisé ou soit une requete jpql
        //Page<BookmarkDTO> bookmarkPage = this.bookmarkRepository.searchBookmarks(query,pageable);
        
        Page<BookmarkDTO> bookmarkPage = this.bookmarkRepository.findByTitleContainsIgnoreCase(query, pageable);
        return new BookmarksDTO(bookmarkPage);
    }

    public BookmarkDTO addBookmark(AddBookmarkDTO addBookmark) {
        Bookmark bookmark = new Bookmark();
        bookmark.setTitle(addBookmark.getTitle());
        bookmark.setUrl(addBookmark.getUrl());
        bookmark.setDescription(addBookmark.getDescription());
        bookmark.setCreatedAt(Instant.now());
        
        Bookmark savedBookmark = this.bookmarkRepository.save(bookmark);
        return bookmarkMapper.toDTO(savedBookmark);
    }

}
