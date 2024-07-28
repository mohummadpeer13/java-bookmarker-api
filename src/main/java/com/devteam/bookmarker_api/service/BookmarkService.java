package com.devteam.bookmarker_api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devteam.bookmarker_api.dto.BookmarksDTO;
import com.devteam.bookmarker_api.entity.Bookmark;
import com.devteam.bookmarker_api.repository.BookmarkRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Transactional(readOnly = true)
    public BookmarksDTO findAllBookmarks(Integer page) {
        int pageNo = page < 1 ? 0 : page -1;
        Pageable pageable = PageRequest.of(pageNo,10,Sort.Direction.ASC, "title");
        return new BookmarksDTO(this.bookmarkRepository.findAll(pageable));
    }

}
