package com.devteam.bookmarker_api.entity;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="bookmarks")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bookmark {
    @Id
    @SequenceGenerator(name="bm_idseq_gen",sequenceName = "bm_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bm_id_seq")
    private Long id;

    @Column(nullable = false)
    private String Title;

    @Column(nullable=false)
    private String url;

    private Instant createdAt;

}
