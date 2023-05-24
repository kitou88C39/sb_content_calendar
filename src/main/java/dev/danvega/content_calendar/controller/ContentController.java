package dev.danvega.content_calendar.controller;

import dev.danvega.content_calendar.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import dev.danvega.content_calendar.repository.ContentCollectionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus, NOT_FOUND, "Content not fount!"));

    }

    @PostMapping("")
    public void create(@RequestBody Content content) {
        repository.save(content);
    }
}
