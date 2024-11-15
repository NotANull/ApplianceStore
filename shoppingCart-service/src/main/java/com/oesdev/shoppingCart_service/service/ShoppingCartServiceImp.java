package com.oesdev.shoppingCart_service.service;

import com.oesdev.shoppingCart_service.dto.ProductDto;
import com.oesdev.shoppingCart_service.dto.ShoppingCartDto;
import com.oesdev.shoppingCart_service.entity.Product;
import com.oesdev.shoppingCart_service.entity.ShoppingCart;
import com.oesdev.shoppingCart_service.exception.ProductNotFoundException;
import com.oesdev.shoppingCart_service.mapper.IShoppingCartMapper;
import com.oesdev.shoppingCart_service.repository.IProductAPI;
import com.oesdev.shoppingCart_service.repository.IShoppingCartRepository;
import feign.FeignException;
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
    public String addProductToCart(Long id, Long productCode) {

        //Dejar preparado el manejo de las excepciones
        //utilizar multi-catch o '|' en uno solo
        ShoppingCart shoppingCartEntity = this.shoppingCartRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Shopping cart with " + id + " not found"));

        try {
            ProductDto productDto = this.productAPI.getProductByCode(productCode);
            Product productEntity = IShoppingCartMapper.mapper.toEntity(productDto);
            shoppingCartEntity.getListProducts().add(productEntity);
            shoppingCartEntity.setTotalPrice(shoppingCartEntity.getTotalPrice() + productEntity.getPrice());
        } catch (FeignException.InternalServerError e) {
            throw new ProductNotFoundException("Product not found in Product-Service");
        }

        this.shoppingCartRepository.save(shoppingCartEntity);

        return "The product is in the cart";
    }

    @Override
    public ShoppingCartDto getShoppingCart(Long id) {
        return null;
    }

    @Override
    public ShoppingCartDto getShoppingCarts() {
        return null;
    }


}
