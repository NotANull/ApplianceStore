package com.oesdev.shoppingCart_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponseDto {

    private Long code;
    private String name;
    private String brand;
    private Double price;

}
