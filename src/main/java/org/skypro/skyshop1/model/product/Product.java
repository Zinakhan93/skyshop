package org.skypro.skyshop1.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop1.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private final UUID id;
    private   final String name;

    public Product(UUID id,String name) {
        this.id = id;
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название строки не может быть пустым или равным null");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return getName();
    }
    @JsonIgnore
    @Override
    public String getContentType() {
        return "PRODUCT";
    }
    @Override
    public String getSearchableName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}