package org.skypro.skyshop1.model.search;

import org.springframework.stereotype.Service;

import java.util.UUID;


public class SearchResult {
    private final UUID id;
    private final String name;
    private final String contentType;

    public SearchResult(UUID id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }
    // Статический фабричный метод для создания SearchResult из Searchable
    public static SearchResult fromSearchable(Searchable s) {
        return new SearchResult(s.getId(),
                s.getSearchableName(),
                s.getContentType());
    }
}
