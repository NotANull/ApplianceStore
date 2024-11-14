package com.oesdev.product_service.service;

import com.oesdev.product_service.dto.ProductDto;
import com.oesdev.product_service.entity.Product;
import com.oesdev.product_service.mapper.ProductMapper;
import com.oesdev.product_service.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements IProductService{

    private final IProductRepository productRepository;
    public ProductServiceImp(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String createProduct(ProductDto productDto) {

        Product productEntity = ProductMapper.mapper.toEntity(productDto);

        this.productRepository.save(productEntity);

        return "Product Created" +
                "\nName: " + productDto.getName() +
                "\nBrand: " + productDto.getBrand() +
                "\nPrice: " + productDto.getPrice();
    }

    @Override
    public ProductDto getProduct(Long productCode) {

        //implement custom exceptions
        Product productEntity = this.productRepository.findById(productCode)
                .orElseThrow(() -> new RuntimeException("Product with " + productCode + " not found"));

        return ProductMapper.mapper.toResponseDto(productEntity);
    }

    @Override
    public List<ProductDto> getProducts() {
        return this.productRepository.findAll().stream()
                .map(p -> ProductMapper.mapper.toResponseDto(p))
                .toList();
    }

    @Override
    public String updateProduct(ProductDto productDto, Long productCode) {

        Product productEntity = this.productRepository.findById(productCode)
                .orElseThrow(() -> new RuntimeException("Product with " + productCode + " not found"));

        ProductMapper.mapper.updateProductFromDto(productDto, productEntity);

        this.productRepository.save(productEntity);

        return "Updated Product";

    }

    @Override
    public String deleteProduct(Long productCode) {

        Optional<Product> productEntity = this.productRepository.findById(productCode);

        if (productEntity.isEmpty()){
            return "The code with product " + productCode + " does not exist! Please enter another code.";
        }

        this.productRepository.delete(productEntity.get());

        return "Product deleted";
    }
}
