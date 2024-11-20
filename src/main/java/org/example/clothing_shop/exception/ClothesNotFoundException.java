package org.example.clothing_shop.exception;

public class ClothesNotFoundException extends RuntimeException {

    public ClothesNotFoundException(String message) {
        super(message);
    }

    public ClothesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}