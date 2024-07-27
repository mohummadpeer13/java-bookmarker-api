package com.devteam.bookmarker_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devteam.bookmarker_api.entity.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

}
