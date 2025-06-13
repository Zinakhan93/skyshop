package org.skypro.skyshop1.model.basket;

import java.util.List;

public class UserBasket {
private final List<BasketItem> items;
private final int totalPrice;

public UserBasket(List<BasketItem> items){
    this.items = items;
    this.totalPrice = items.stream()
            .mapToInt(item -> item.getProduct().getPrice() * item.getQuantity())
            .sum();
}

    public List<BasketItem> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
