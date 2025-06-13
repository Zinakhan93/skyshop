package org.skypro.skyshop1.service;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<SearchResult> search(String pattern) {
        String lowerPattern = pattern.toLowerCase();
        return storageService.getAllSearchables().stream()
                .map(SearchResult::fromSearchable)
                .filter(sr -> sr.getName().toLowerCase().contains(lowerPattern))
                .collect(Collectors.toList());
    }



}
