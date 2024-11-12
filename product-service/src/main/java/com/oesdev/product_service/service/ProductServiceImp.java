package com.oesdev.product_service.service;

import com.oesdev.product_service.dto.request.ProductRequestDto;
import com.oesdev.product_service.dto.response.ProductResponseDto;
import com.oesdev.product_service.entity.Product;
import com.oesdev.product_service.mapper.ProductMapper;
import com.oesdev.product_service.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements IProductService{

    private IProductRepository productRepository;
    public ProductServiceImp(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String createProduct(ProductRequestDto productRequestDto) {

        Product productEntity = ProductMapper.mapper.toEntity(productRequestDto);

        this.productRepository.save(productEntity);

        return "Product Created" +
                "\nName: " + productRequestDto.getName() +
                "\nBrand: " + productRequestDto.getBrand() +
                "\nPrice: " + productRequestDto.getPrice();
    }

    @Override
    public ProductResponseDto getProduct(Long productCode) {

        Product productEntity = this.productRepository.findById(productCode).orElse(null);

        if (productEntity == null) {
            return null;
        }

        return ProductMapper.mapper.toResponseDto(productEntity);
    }

    @Override
    public List<ProductResponseDto> getProducts() {
        return this.productRepository.findAll().stream()
                .map(p -> ProductMapper.mapper.toResponseDto(p))
                .toList();
    }

    @Override
    public String updateProduct(ProductRequestDto productRequestDto, Long productCode) {

        Product productEntity = this.productRepository.findById(productCode).orElse(null);

        if (productEntity == null) {
            return "Code not found";
        }

        ProductMapper.mapper.updateProductFromDto(productRequestDto, productEntity);

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
