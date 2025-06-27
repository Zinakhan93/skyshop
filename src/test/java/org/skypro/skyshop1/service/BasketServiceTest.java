package org.skypro.skyshop1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop1.exception.NoSuchProductException;
import org.skypro.skyshop1.model.basket.ProductBasket;
import org.skypro.skyshop1.model.basket.UserBasket;
import org.skypro.skyshop1.model.product.Product;
import org.skypro.skyshop1.model.product.SimpleProduct;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static java.util.Map.*;
//import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension .class)
public class BasketServiceTest {
    @Mock
    private ProductBasket productBasket;

    @Mock
    private StorageService storageService;

    @InjectMocks
    private BasketService basketService;

    @Test
    void addProduct_shouldThrowException_whenProductNotFound() {
        // Подготовка
        UUID productId = UUID.randomUUID();
        when(storageService.getProductById(productId)).thenReturn(Optional.empty());

        // Действие и проверка
        assertThrows(NoSuchProductException.class,
                () -> basketService.addProduct(productId));

        verify(productBasket, never()).addProduct(any());
    }

    @Test
    void addProduct_shouldAddToBasket_whenProductExists() {
        // Подготовка
        UUID productId = UUID.randomUUID();
        Product product = new SimpleProduct(productId, "Apple", 100);
        when(storageService.getProductById(productId)).thenReturn(Optional.of(product));

        // Действие
        basketService.addProduct(productId);

        // Проверка
        verify(productBasket).addProduct(productId);
    }
    @Test
    void getUserBasket_shouldReturnEmptyBasket_whenNoProducts() {
        // Подготовка
        when(productBasket.getProductsInBasket()).thenReturn(of());

        // Действие
        UserBasket result = basketService.getUserBasket();

        // Проверка
        assertTrue(result.getItems().isEmpty());
        assertEquals(0, result.getTotalPrice());
    }



    @Test
    void getUserBasket_shouldCalculateTotalCorrectly() {
        // Подготовка
        UUID product1 = UUID.randomUUID();
        UUID product2 = UUID.randomUUID();

        when(productBasket.getProductsInBasket())
                .thenReturn(of(
                        product1, 2,
                        product2, 3
                ));
        when(storageService.getProductById(product1))
                .thenReturn(Optional.of(new SimpleProduct(product1, "A", 100)));
        when(storageService.getProductById(product2))
                .thenReturn(Optional.of(new SimpleProduct(product2, "B", 50)));

        // Действие
        UserBasket result = basketService.getUserBasket();

        // Проверка
        assertEquals(350, result.getTotalPrice());
    }



}
