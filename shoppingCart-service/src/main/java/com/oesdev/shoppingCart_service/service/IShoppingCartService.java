package com.oesdev.shoppingCart_service.service;

import com.oesdev.shoppingCart_service.dto.ShoppingCartDto;

public interface IShoppingCartService {

    String createShoppingCart();

    String addProductToCart(Long id, Long productCode);

    ShoppingCartDto getShoppingCart(Long id);
}
