package com.oesdev.sale_service.service;

import com.oesdev.sale_service.dto.SaleDto;
import com.oesdev.sale_service.dto.ShoppingCartDto;
import com.oesdev.sale_service.entity.Sale;
import com.oesdev.sale_service.exception.SaleNotFoundException;
import com.oesdev.sale_service.exception.ShoppingCartNotFoundException;
import com.oesdev.sale_service.mapper.ISaleMapper;
import com.oesdev.sale_service.repository.ISaleRepository;
import com.oesdev.sale_service.repository.IShoppingCartAPI;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SaleServiceImp implements ISaleService{

    private final ISaleRepository saleRepository;
    private final IShoppingCartAPI shoppingCartAPI;

    public SaleServiceImp(ISaleRepository saleRepository, IShoppingCartAPI shoppingCartAPI) {
        this.saleRepository = saleRepository;
        this.shoppingCartAPI = shoppingCartAPI;
    }

    @Override
    public String createSale(Long shoppingCartId) {

        try {
            ShoppingCartDto shoppingCartDto = this.shoppingCartAPI.getShoppingCart(shoppingCartId);
            Sale sale = Sale.builder()
                    .saleDate(LocalDate.now())
                    .shoppingCartId(shoppingCartId)
                    .build();
            this.saleRepository.save(sale);
        } catch (FeignException.NotFound e) {
            throw  new ShoppingCartNotFoundException("Shopping cart with id " + shoppingCartId + " not found");
        }


        return "Sale created Successfully";
    }

    @Override
    public SaleDto getSale(Long id) {

        Sale saleEntity = this.saleRepository.findById(id)
                .orElseThrow(() -> new SaleNotFoundException("Sale with id " + id + " not found"));

        ShoppingCartDto shoppingCartFromAPI = this.shoppingCartAPI.getShoppingCart(saleEntity.getShoppingCartId());

        return SaleDto.builder()
                .id(id)
                .saleDate(saleEntity.getSaleDate())
                .totalPrice(shoppingCartFromAPI.getTotalPrice())
                .productDtoList(shoppingCartFromAPI.getListProducts())
                .build();

    }
}
