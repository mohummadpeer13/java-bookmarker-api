package com.devteam.bookmarker_api.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
// if use jpql not required @NoArgsConstructor
public class BookmarkDTO {
    private Long id;
    private String title;
    private String url;
    private Instant createdAt;
    private String description;
}
