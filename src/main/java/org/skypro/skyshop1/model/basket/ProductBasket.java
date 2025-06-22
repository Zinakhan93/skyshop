package org.skypro.skyshop1.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID,Integer> products = new HashMap<>();


    public void addProduct (UUID product){
        if (products.containsKey(product)){
            products.put(product,products.get(product)+1);
        } else {
            products.put(product, 1);

        }

    }
     /* Другой метод  Добавляет товар по id в корзину.
    Если товар уже есть, увеличивает количество.
    public void addProduct(UUID id) {
        products.put(id, products.getOrDefault(id, 0) + 1);
    }*/

    //Возвращает все товары и их количества в виде неизменяемой карты.
    public Map<UUID, Integer> getProductsInBasket() {
        return Collections.unmodifiableMap(products);
    }



}
