package org.skypro.skyshop1.service;


import org.skypro.skyshop1.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search(String pattern) {
        String queryLower =pattern .toLowerCase();
        return storageService.getAllSearchables().stream()
                .filter(item -> item.getSearchableName().toLowerCase().contains(queryLower))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }



   /* public List<SearchResult> search(String pattern) {
        String lowerPattern = pattern.toLowerCase();
        return storageService.getAllSearchables().stream()
                .map(SearchResult::fromSearchable)
                .filter(sr -> sr.getName().toLowerCase().contains(lowerPattern))
                .collect(Collectors.toList());
    }*/



}
