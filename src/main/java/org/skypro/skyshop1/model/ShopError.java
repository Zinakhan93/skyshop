package org.skypro.skyshop1.model;

import java.util.Objects;

public class ShopError {
    private final String code;
    private final String message;

    public ShopError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShopError shopError = (ShopError) o;
        return Objects.equals(code, shopError.code) && Objects.equals(message, shopError.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }
}
