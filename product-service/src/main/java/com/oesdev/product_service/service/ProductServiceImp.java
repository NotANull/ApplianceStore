package com.oesdev.product_service.service;

import com.oesdev.product_service.dto.request.ProductRequestDto;
import com.oesdev.product_service.dto.response.ProductResponseDto;
import com.oesdev.product_service.entity.Product;
import com.oesdev.product_service.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements IProductService{

    private IProductRepository productRepository;

    public ProductServiceImp(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {

        Product productEntity = Product.builder()
                .name(productRequestDto.getName())
                .brand(productRequestDto.getBrand())
                .price(productRequestDto.getPrice())
                .build();

        this.productRepository.save(productEntity);

        return new ProductResponseDto(
                "Product saved",
                productRequestDto.getName(),
                productRequestDto.getBrand(),
                productRequestDto.getPrice()
        );
    }

    @Override
    public ProductResponseDto getProduct(Long productCode) {

        Product productEntity = this.productRepository.findById(productCode).orElse(null);

        if (productEntity == null) {
            return null;
        }

        return ProductResponseDto.builder()
                .message("Product Information")
                .name(productEntity.getName())
                .brand(productEntity.getBrand())
                .price(productEntity.getPrice())
                .build();
    }

    @Override
    public List<ProductResponseDto> getProducts() {
        return this.productRepository.findAll().stream()
                .map(p -> ProductResponseDto.builder()
                        .message("-")
                        .name(p.getName())
                        .brand(p.getBrand())
                        .price(p.getPrice())
                        .build())
                .toList();

    }

    @Override
    public String updateProduct(ProductRequestDto productRequestDto, Long productCode) {

        Product productEntity = this.productRepository.findById(productCode).orElse(null);

        if (productEntity == null) {
            return "Code not found";
        }

        Field[] fields = productRequestDto.getClass().getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(productRequestDto);
                if(value != null) {
                    Field productField = Product.class.getDeclaredField(field.getName());
                    productField.setAccessible(true);
                    productField.set(productEntity, value);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }

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
