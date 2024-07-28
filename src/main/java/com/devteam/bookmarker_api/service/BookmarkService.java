package com.devteam.bookmarker_api.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devteam.bookmarker_api.dto.BookmarkDTO;
import com.devteam.bookmarker_api.dto.BookmarksDTO;
import com.devteam.bookmarker_api.repository.BookmarkRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

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

}
