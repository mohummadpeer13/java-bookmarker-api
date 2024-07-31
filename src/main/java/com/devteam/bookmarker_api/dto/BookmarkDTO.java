package com.devteam.bookmarker_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
// if use jpql not required @NoArgsConstructor
public class BookmarkDTO {

    private String title;
    private String url;
    private String description;

}
