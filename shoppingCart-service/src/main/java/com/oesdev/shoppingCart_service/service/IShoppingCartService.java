package com.oesdev.shoppingCart_service.service;

import com.oesdev.shoppingCart_service.dto.ShoppingCartDto;

import java.util.List;

public interface IShoppingCartService {

    String createShoppingCart();

    String addProductToCart(Long id, Long productCode);

    ShoppingCartDto getShoppingCart(Long id);

    List<ShoppingCartDto> getShoppingCarts();

    String removeProductFromCart(Long id, Long productCode);

    String deleteShoppingCart(Long id);
}
