package org.skypro.skyshop1.model.search;

import java.util.UUID;

public interface Searchable {
    String getSearchTerm();

    String getContentType();
    String getSearchableName();
    default String getStringRepresentation() {
        return String.format("%s-%s",getSearchableName(),getContentType());
    }
    UUID getId();

}
