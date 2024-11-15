package com.oesdev.shoppingCart_service.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(FeignException.InternalServerError.class)
    public ResponseEntity<String> handleFeignNotFound(FeignException e) {
        return new ResponseEntity<>("Product not found in Product-Service", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleShoppingCartNotFound(ProductNotFoundException e) {
        return new ResponseEntity<>("Shopping cart not found", HttpStatus.NOT_FOUND);
    }
}
