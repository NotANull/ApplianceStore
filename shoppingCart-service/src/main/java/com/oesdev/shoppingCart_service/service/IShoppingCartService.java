package com.oesdev.shoppingCart_service.service;

import com.oesdev.shoppingCart_service.dto.ShoppingCartDto;

public interface IShoppingCartService {

    String createShoppingCart();

    ShoppingCartDto getShoppingCart(Long id);
}
