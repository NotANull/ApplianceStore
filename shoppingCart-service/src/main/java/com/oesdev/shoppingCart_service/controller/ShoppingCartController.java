package com.oesdev.shoppingCart_service.controller;

import com.oesdev.shoppingCart_service.dto.ShoppingCartDto;
import com.oesdev.shoppingCart_service.service.IShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    private final IShoppingCartService shoppingCartService;

    public ShoppingCartController(IShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createShoppingCart() {
        return new ResponseEntity<>(this.shoppingCartService.createShoppingCart(), HttpStatus.CREATED);
    }

    @PostMapping("/add-product/{id}/{code}")
    public ResponseEntity<String> addProductToCart(@PathVariable Long id, @PathVariable Long code) {
        return new ResponseEntity<>(this.shoppingCartService.addProductToCart(id, code), HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<ShoppingCartDto> getShoppingCart(@PathVariable Long id) {
        return new ResponseEntity<>(this.shoppingCartService.getShoppingCart(id), HttpStatus.OK);
    }

    @GetMapping("/read/list")
    public ResponseEntity<List<ShoppingCartDto>> getShoppingCarts() {
        return new ResponseEntity<>(this.shoppingCartService.getShoppingCarts(), HttpStatus.OK);
    }
}
