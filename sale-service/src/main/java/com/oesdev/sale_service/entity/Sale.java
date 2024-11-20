package com.oesdev.sale_service.entity;

import com.oesdev.sale_service.dto.ShoppingCartDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate saleDate;
    @Transient
    private ShoppingCartDto shoppingCart;
}
