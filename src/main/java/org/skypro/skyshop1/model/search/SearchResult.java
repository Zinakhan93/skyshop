package org.skypro.skyshop1.model.search;

public class SearchResult {
    private final String id;
    private final String name;
    private final String contentType;

    public SearchResult(String id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }
    public String getId() {
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
        return new SearchResult(s.getId().toString(), s.getSearchableName(), s.getContentType());
    }
}
