package org.skypro.skyshop1.exception;

import java.util.UUID;

public class NoSuchProductException extends RuntimeException{
    public NoSuchProductException(UUID id) {
        super("Product not found with ID: " + id);
    }
}
