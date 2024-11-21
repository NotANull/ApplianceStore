package com.oesdev.sale_service.exception;

public class ShoppingCartNotFoundException extends RuntimeException{

    public ShoppingCartNotFoundException(String message) {
        super(message);
    }
}
