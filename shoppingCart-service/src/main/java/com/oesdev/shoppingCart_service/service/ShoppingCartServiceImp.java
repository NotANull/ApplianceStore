package com.oesdev.shoppingCart_service.service;

import com.oesdev.shoppingCart_service.dto.ProductDto;
import com.oesdev.shoppingCart_service.dto.ShoppingCartDto;
import com.oesdev.shoppingCart_service.entity.Product;
import com.oesdev.shoppingCart_service.entity.ShoppingCart;
import com.oesdev.shoppingCart_service.exception.ProductNotFoundException;
import com.oesdev.shoppingCart_service.exception.ShoppingCartNotFoundException;
import com.oesdev.shoppingCart_service.mapper.IShoppingCartMapper;
import com.oesdev.shoppingCart_service.repository.IProductAPI;
import com.oesdev.shoppingCart_service.repository.IProductRepository;
import com.oesdev.shoppingCart_service.repository.IShoppingCartRepository;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImp implements IShoppingCartService{

    private final IProductAPI productAPI;
    private final IShoppingCartRepository shoppingCartRepository;
    private final IProductRepository productRepository;

    public ShoppingCartServiceImp(IProductAPI productAPI, IShoppingCartRepository shoppingCartRepository, IProductRepository productRepository) {
        this.productAPI = productAPI;
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public String createShoppingCart() {
        this.shoppingCartRepository.save(new ShoppingCart());
        return "Shopping cart created";
    }

    @Override
    @CircuitBreaker(name = "productServiceCircuitBreaker", fallbackMethod = "fallbackGetProduct")
    public String addProductToCart(Long id, Long productCode) {

        ShoppingCart shoppingCartEntity = this.shoppingCartRepository.findById(id)
                .orElseThrow(() -> new ShoppingCartNotFoundException("Shopping cart with " + id + " not found."));

        ProductDto productDto = this.productAPI.getProductByCode(productCode);
        Product productEntity = IShoppingCartMapper.mapper.toEntity(productDto);

        shoppingCartEntity.getListProducts().add(productEntity);
        shoppingCartEntity.setTotalPrice(shoppingCartEntity.getTotalPrice() + productEntity.getPrice());

        this.shoppingCartRepository.save(shoppingCartEntity);

        return "The product is in the cart";
    }

    public String fallbackGetProduct(Long id, Long productCode, Throwable throwable) {
        if (throwable instanceof FeignException.NotFound) {
            return "Product with code " + productCode + " not found";
        } else {
            return "Could not add product to cart due to unexpected error: " + throwable.getMessage();
        }
    }


    @Override
    public ShoppingCartDto getShoppingCart(Long id) {

        ShoppingCart shoppingCartEntity = this.shoppingCartRepository.findById(id)
                .orElseThrow(() -> new ShoppingCartNotFoundException("Shopping cart with " + id + " not found"));

        return IShoppingCartMapper.mapper.toDto(shoppingCartEntity);
    }

    @Override
    public List<ShoppingCartDto> getShoppingCarts() {
        return this.shoppingCartRepository.findAll().stream()
                .map(IShoppingCartMapper.mapper::toDto)
                .toList();
    }

    @Override
    public String removeProductFromCart(Long id, Long productCode) {

        ShoppingCart shoppingCartEntity = this.shoppingCartRepository.findById(id)
                .orElseThrow(() -> new ShoppingCartNotFoundException("Shopping cart with " + id + " not found"));

        Product productEntity = shoppingCartEntity.getListProducts().stream()
                .filter(p -> p.getCode().equals(productCode))
                .findFirst().orElseThrow(() -> new ProductNotFoundException("Product with code " + productCode + " not found"));

        shoppingCartEntity.setTotalPrice(shoppingCartEntity.getTotalPrice() - productEntity.getPrice());

        shoppingCartEntity.getListProducts().remove(productEntity);

        this.shoppingCartRepository.save(shoppingCartEntity);

        return "Product with " + productCode + " removed from cart";
    }

    @Override
    public String deleteShoppingCart(Long id) {

        Optional<ShoppingCart> shoppingCartEntity = this.shoppingCartRepository.findById(id);

        if (shoppingCartEntity.isEmpty()) {
            return "Shopping cart with code " + id + " does not exist!";
        }

        this.shoppingCartRepository.delete(shoppingCartEntity.get());

        return "Shopping cart deleted";
    }


}
