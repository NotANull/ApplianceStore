package com.oesdev.sale_service.controller;

import com.oesdev.sale_service.service.ISaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private final ISaleService saleService;

    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/create/{shoppingCartId}")
    public ResponseEntity<String> createSale(@PathVariable Long shoppingCartId) {
        return new ResponseEntity<>(this.saleService.createSale(shoppingCartId), HttpStatus.OK);
    }
}
