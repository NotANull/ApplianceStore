package com.oesdev.sale_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaleDto {

    private Long id;
    private LocalDate saleDate;
    private Long shoppingCartId;

}
