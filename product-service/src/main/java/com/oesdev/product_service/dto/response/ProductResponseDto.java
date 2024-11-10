package com.oesdev.product_service.dto.response;

import com.oesdev.product_service.dto.request.ProductRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponseDto {

    private String message;
    private String name;
    private String brand;
    private Double price;

}
