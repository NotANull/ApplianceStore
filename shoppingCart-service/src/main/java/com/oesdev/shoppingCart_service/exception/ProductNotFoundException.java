package com.oesdev.shoppingCart_service.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message) {
        super(message);
    }

}
