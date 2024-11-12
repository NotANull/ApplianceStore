package com.oesdev.product_service.service;

import com.oesdev.product_service.dto.request.ProductRequestDto;
import com.oesdev.product_service.dto.response.ProductResponseDto;

import java.util.List;

public interface IProductService {

    String createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto getProduct(Long productCode);

    List<ProductResponseDto> getProducts();

    String updateProduct(ProductRequestDto productRequestDto, Long productCode);

    String deleteProduct(Long productCode);
}
