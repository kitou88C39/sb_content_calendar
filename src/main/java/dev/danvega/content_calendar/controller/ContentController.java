package dev.danvega.content_calendar.controller;

import dev.danvega.content_calendar.model.Content;
import dev.danvega.content_calendar.repository.ContentCollectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    @Autowired
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    };

    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }
}
