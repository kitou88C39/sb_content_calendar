package dev.danvega.content_calendar.repository;

import dev.danvega.content_calendar.model.Content;
import dev.danvega.content_calendar.model.Status;
import dev.danvega.content_calendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.add(content);
    }

    @PostConstruct
    private void init(){
        Content content = new Content(id: 1, 
                title: "My First Blog Post",
                desc: "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                dateUpdated: null,
                url: "");

        content.add(content);
    }
}