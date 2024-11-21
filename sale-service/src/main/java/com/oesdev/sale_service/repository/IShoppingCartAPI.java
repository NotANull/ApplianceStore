package com.oesdev.sale_service.repository;

import com.oesdev.sale_service.dto.ShoppingCartDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "shoppingCart-service")
public interface IShoppingCartAPI {

    @GetMapping("/shoppingcart/read/{id}")
    ShoppingCartDto getShoppingCart(@PathVariable("id") Long id);

}
