package com.devteam.bookmarker_api.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devteam.bookmarker_api.entity.Bookmark;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarksDTO {
    private List<Bookmark> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;

    @JsonProperty("isFirst")
    private boolean isFirst;

    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hastNext;
    private boolean hasPrevious;

    public BookmarksDTO (Page<Bookmark> bookmarkPage){
        this.setData(bookmarkPage.getContent());
        this.setTotalElements(bookmarkPage.getTotalElements());
        this.setTotalPages(bookmarkPage.getTotalPages());
        this.setCurrentPage(bookmarkPage.getNumber()+1);
        this.setFirst(bookmarkPage.isFirst());
        this.setLast(bookmarkPage.isLast());
        this.setHastNext(bookmarkPage.hasNext());
        this.setHasPrevious(bookmarkPage.hasPrevious());
    }
    
}
