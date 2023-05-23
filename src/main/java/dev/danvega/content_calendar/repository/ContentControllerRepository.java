package dev.danvega.content_calendar.repository;

import dev.danvega.content_calendar.model.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContentControllerRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentControllerRepository() {
    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
}
