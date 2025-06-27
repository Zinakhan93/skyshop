package org.skypro.skyshop1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop1.model.product.Product;
import org.skypro.skyshop1.model.product.SimpleProduct;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;
    @Test
    void search_shouldReturnEmptyList_whenNoObjectsInStorage() {
        // Подготовка
        when(storageService.getAllSearchables()).thenReturn(Collections.emptyList());

        // Действие
        var result = searchService.search("query");

        // Проверка
        assertTrue(result.isEmpty());
        verify(storageService).getAllSearchables();
    }
    @Test
    void search_shouldReturnEmptyList_whenNoMatchesFound() {
        // Подготовка
        Product product = new SimpleProduct(UUID.randomUUID(), "Apple", 100);
        when(storageService.getAllSearchables()).thenReturn(List.of(product));

        // Действие
        var result = searchService.search("Orange");

        // Проверка
        assertTrue(result.isEmpty());
    }
    @Test
    void search_shouldReturnResults_whenMatchesExist() {
        // Подготовка
        Product product1 = new SimpleProduct(UUID.randomUUID(), "Apple", 100);
        Product product2 = new SimpleProduct(UUID.randomUUID(), "Pineapple", 150);
        when(storageService.getAllSearchables()).thenReturn(List.of(product1, product2));

        // Действие
        var result = searchService.search("apple");

        // Проверка
        assertEquals(2, result.size());
    }
    @Test
    void search_shouldBeCaseInsensitive() {
        // Подготовка
        Product product = new SimpleProduct(UUID.randomUUID(), "Apple", 100);
        when(storageService.getAllSearchables()).thenReturn(List.of(product));

        // Действие
        var result = searchService.search("APPLE");

        // Проверка
        assertEquals(1, result.size());
    }


}
