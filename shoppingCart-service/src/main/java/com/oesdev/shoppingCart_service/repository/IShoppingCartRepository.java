package com.oesdev.shoppingCart_service.repository;

import com.oesdev.shoppingCart_service.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
