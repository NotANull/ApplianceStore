package com.oesdev.sale_service.exception;

public class SaleNotFoundException extends RuntimeException{

    public SaleNotFoundException(String message) {
        super(message);
    }
}
