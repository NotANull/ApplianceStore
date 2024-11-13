package com.oesdev.product_service.controller;

import com.oesdev.product_service.dto.ProductDto;
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
    public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(this.productService.createProduct(productDto), HttpStatus.OK);
    }

    @GetMapping("/read/{code}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long code) {
        return new ResponseEntity<>(this.productService.getProduct(code), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getProducts() {
        return new ResponseEntity<>(this.productService.getProducts(), HttpStatus.OK);
    }

    @PutMapping("/update/{code}")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto, @PathVariable Long code){
        return new ResponseEntity<>(this.productService.updateProduct(productDto, code), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long code) {
        return new ResponseEntity<>(this.productService.deleteProduct(code), HttpStatus.OK);
    }
}
