package com.oesdev.sale_service.service;

import com.oesdev.sale_service.dto.ShoppingCartDto;
import com.oesdev.sale_service.entity.Sale;
import com.oesdev.sale_service.exception.ShoppingCartNotFoundException;
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
            Sale sale = new Sale();
            sale.setSaleDate(LocalDate.now());
            sale.setShoppingCart(shoppingCartDto);
            this.saleRepository.save(sale);
        } catch (FeignException.NotFound e) {
            throw  new ShoppingCartNotFoundException("Shopping cart with id " + shoppingCartId + " not found");
        }


        return "Sale created Successfully";
    }
}
