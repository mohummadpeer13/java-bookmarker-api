package com.devteam.bookmarker_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devteam.bookmarker_api.dto.BookmarkDTO;
import com.devteam.bookmarker_api.entity.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    // if you have 30 fields => select only field you want in the table and mapper it to DTO
    @Query("select new com.devteam.bookmarker_api.dto.BookmarkDTO(b.title,b.url,b.description) from Bookmark b")
    Page<BookmarkDTO> findBookmarks(Pageable pageable);

    @Query("""
        select new com.devteam.bookmarker_api.dto.BookmarkDTO(b.title,b.url,b.description) from Bookmark b
        where lower(b.title) like lower(concat('%',:query,'%'))
        """)
    Page<BookmarkDTO> searchBookmarks(String query, Pageable pageable);

}
