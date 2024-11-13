package com.oesdev.shoppingCart_service.service;

import com.oesdev.shoppingCart_service.dto.response.ShoppingCartResponseDto;
import com.oesdev.shoppingCart_service.entity.ShoppingCart;
import com.oesdev.shoppingCart_service.repository.IProductAPI;
import com.oesdev.shoppingCart_service.repository.IShoppingCartRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImp implements IShoppingCartService{

    private IProductAPI productAPI;
    private IShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImp(IProductAPI productAPI, IShoppingCartRepository shoppingCartRepository) {
        this.productAPI = productAPI;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public String createShoppingCart() {
        this.shoppingCartRepository.save(new ShoppingCart());
        return "Shopping cart created";
    }

    @Override
    public ShoppingCartResponseDto getShoppingCart(Long id) {
        return null;
    }
}
