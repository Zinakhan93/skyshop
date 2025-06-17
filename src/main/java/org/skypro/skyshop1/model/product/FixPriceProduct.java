package org.skypro.skyshop1.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product{
    private final int FIX_PRICE=50;

    public FixPriceProduct(UUID id, String name) {
        super(id,name);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ": Фиксированная цена " + FIX_PRICE;
    }
}
