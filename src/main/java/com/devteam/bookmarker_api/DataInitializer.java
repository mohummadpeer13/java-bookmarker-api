package com.devteam.bookmarker_api;

import java.time.Instant;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.devteam.bookmarker_api.entity.Bookmark;
import com.devteam.bookmarker_api.repository.BookmarkRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner{
    private final BookmarkRepository bookmarkRepository;

    @Override
    public void run(String... args) throws Exception {
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        this.bookmarkRepository.save(new Bookmark(null,"rre","rrr",Instant.now()));
        List<Bookmark> book = bookmarkRepository.findAll(); 
        System.out.println(book.size());

    }

    
    
}
