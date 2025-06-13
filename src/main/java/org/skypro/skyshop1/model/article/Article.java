package org.skypro.skyshop1.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop1.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public final class Article implements Searchable {
    private final UUID id;
    private String title;
    private String text;

    public Article(UUID id ,String title, String text) {
        this.id = id;
        if (title==null || title.isBlank()){
            throw new IllegalArgumentException("Название статьи не может быть пустым или null");
        }
        this.title = title;
        if (text==null|| text.isBlank()){
            throw new IllegalArgumentException("Текст статьи не может быть пустым или null");
        }
        this.text = text;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return toString();
    }
    @Override
    public String getSearchableName() {
        return title;
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return "ARTICLE";
    }
    @Override
    public String toString() {
        return title  + text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) && Objects.equals(text, article.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}
