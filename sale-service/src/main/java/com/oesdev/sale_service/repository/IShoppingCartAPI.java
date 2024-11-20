package com.oesdev.sale_service.repository;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "shoppingCart-service")
public interface IShoppingCartAPI {
}
