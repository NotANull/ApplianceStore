package com.oesdev.shoppingCart_service.repository;

import com.oesdev.shoppingCart_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

}