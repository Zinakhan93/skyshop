package org.skypro.skyshop1.service;

import org.skypro.skyshop1.model.basket.BasketItem;
import org.skypro.skyshop1.model.basket.ProductBasket;
import org.skypro.skyshop1.model.basket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }
    public void addProduct(UUID id){
        if (storageService.getProductById(id).isEmpty()){
            throw new IllegalArgumentException("Нет такого продукта");
        }
        productBasket.addProduct(id);

    }

    public UserBasket getUserBasket(){
        List<BasketItem> items = productBasket.getProductsInBasket()
                .entrySet()
                .stream()
                .map(p->new BasketItem(storageService.getProductById(p.getKey()).orElseThrow(),p.getValue()))
                .toList();
        return new UserBasket(items);
    }
}
