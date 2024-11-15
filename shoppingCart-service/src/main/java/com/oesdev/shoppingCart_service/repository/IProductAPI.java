package com.oesdev.shoppingCart_service.repository;

import com.oesdev.shoppingCart_service.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface IProductAPI {

    @GetMapping("product/read/{code}")
    ProductDto getProductByCode(@PathVariable Long code);

}
