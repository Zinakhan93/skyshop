package org.skypro.skyshop1.controller;

import org.skypro.skyshop1.service.SearchResult;
import org.skypro.skyshop1.service.SearchService;
import org.skypro.skyshop1.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class ShopController {
    private final StorageService storageService;
    private final SearchService searchService;

    public ShopController(StorageService storageService, SearchService searchService) {
        this.storageService = storageService;
        this.searchService = searchService;
    }

    @GetMapping("/products")
    public Collection<?> getAllProducts() {
        return storageService.getAllProducts();
    }

    @GetMapping("/articles")
    public Collection<?> getAllArticles() {
        return storageService.getAllArticles();
    }
    // Новый метод поиска
    // Новый метод поиска
    @GetMapping("/search")
    public List<SearchResult> search(@RequestParam("pattern") String pattern) {
        return searchService.search(pattern);
    }



}