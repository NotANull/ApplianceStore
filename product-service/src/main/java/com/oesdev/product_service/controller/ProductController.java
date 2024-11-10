package com.oesdev.product_service.controller;

import com.oesdev.product_service.dto.request.ProductRequestDto;
import com.oesdev.product_service.dto.response.ProductResponseDto;
import com.oesdev.product_service.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return new ResponseEntity<>(this.productService.createProduct(productRequestDto), HttpStatus.OK);
    }

    @GetMapping("/read/{code}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long code) {
        return new ResponseEntity<>(this.productService.getProduct(code), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponseDto>> getProducts() {
        return new ResponseEntity<>(this.productService.getProducts(), HttpStatus.OK);
    }

    @PutMapping("/update/{code}")
    public ResponseEntity<String> updateProduct(@RequestBody ProductRequestDto productRequestDto, @PathVariable Long code){
        return new ResponseEntity<>(this.productService.updateProduct(productRequestDto, code), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long code) {
        return new ResponseEntity<>(this.productService.deleteProduct(code), HttpStatus.OK);
    }
}
