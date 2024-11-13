package com.oesdev.product_service.service;

import com.oesdev.product_service.dto.ProductDto;

import java.util.List;

public interface IProductService {

    String createProduct(ProductDto productRequestDto);

    ProductDto getProduct(Long productCode);

    List<ProductDto> getProducts();

    String updateProduct(ProductDto productRequestDto, Long productCode);

    String deleteProduct(Long productCode);
}
