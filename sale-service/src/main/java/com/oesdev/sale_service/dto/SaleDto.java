package com.oesdev.sale_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaleDto {

    private Long id;
    private LocalDate saleDate;
    private double totalPrice;
    private List<ProductDto> productDtoList;

}
