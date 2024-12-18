package com.oesdev.sale_service.exception;

import com.oesdev.sale_service.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ShoppingCartNotFoundException.class)
    public ResponseEntity<ErrorDto> handleFeignNotFound(ShoppingCartNotFoundException e) {
        ErrorDto errorDto = new ErrorDto(404, e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SaleNotFoundException.class)
    public ResponseEntity<ErrorDto> handleSaleNotFound(SaleNotFoundException e) {
        ErrorDto errorDto = new ErrorDto(404, e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
