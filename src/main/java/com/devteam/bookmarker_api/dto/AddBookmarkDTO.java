package com.devteam.bookmarker_api.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBookmarkDTO {
    @NotEmpty(message="Le titre ne peut être vide")
    String title;

    @NotEmpty(message="L'url ne peut être vide")
    String url;

    String description;
}
