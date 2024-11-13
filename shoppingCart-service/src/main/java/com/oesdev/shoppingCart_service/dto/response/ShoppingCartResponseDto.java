package com.oesdev.shoppingCart_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShoppingCartResponseDto {

    private Double totalPrice;
    private List<ProductResponseDto> listProducts;
}
