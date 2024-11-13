package com.oesdev.shoppingCart_service.service;

import com.oesdev.shoppingCart_service.dto.response.ShoppingCartResponseDto;

public interface IShoppingCartService {

    String createShoppingCart();

    ShoppingCartResponseDto getShoppingCart(Long id);
}
