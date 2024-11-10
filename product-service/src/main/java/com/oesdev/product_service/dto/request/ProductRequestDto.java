package com.oesdev.product_service.dto.request;

import com.oesdev.product_service.dto.response.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequestDto {

    private String name;
    private String brand;
    private Double price;

}
