package com.oesdev.shoppingCart_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShoppingCartDto {

    private Double totalPrice;
    private List<ProductDto> listProducts;
}
