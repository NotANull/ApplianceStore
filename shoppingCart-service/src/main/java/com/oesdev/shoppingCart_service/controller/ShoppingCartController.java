package com.oesdev.shoppingCart_service.controller;

import com.oesdev.shoppingCart_service.service.IShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    private IShoppingCartService shoppingCartService;

    public ShoppingCartController(IShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PutMapping("/create")
    public ResponseEntity<String> createShoppingCart() {
        return new ResponseEntity<>(this.shoppingCartService.createShoppingCart(), HttpStatus.CREATED);
    }
}
