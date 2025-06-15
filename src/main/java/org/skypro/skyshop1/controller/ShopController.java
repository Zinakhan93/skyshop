package org.skypro.skyshop1.controller;
import java.util.UUID;

import org.skypro.skyshop1.model.basket.UserBasket;
import org.skypro.skyshop1.model.search.SearchResult;
import org.skypro.skyshop1.service.BasketService;
import org.skypro.skyshop1.service.SearchService;
import org.skypro.skyshop1.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.server.UID;
import java.util.Collection;
import java.util.List;


@RestController
public class ShopController {
    private final StorageService storageService;
    private final SearchService searchService;
    private final BasketService basketService;

    public ShopController(StorageService storageService, SearchService searchService,BasketService basketService) {
        this.storageService = storageService;
        this.searchService = searchService;
        this.basketService =basketService;
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

    @GetMapping("/search")
    public Collection<SearchResult> search(@RequestParam String pattern) {
        return searchService.search(pattern);
    }
    @GetMapping("/basket/{id}")
    public String addProduct(@PathVariable("id") UUID id) {
        basketService.addProduct(id);
        return "Продукт добавлен";
    }

    @GetMapping("/basket")
    public UserBasket getUserBasket() {
        return basketService.getUserBasket();
    }



}