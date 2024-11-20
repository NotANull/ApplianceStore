package com.oesdev.sale_service.service;

import com.oesdev.sale_service.repository.ISaleRepository;
import com.oesdev.sale_service.repository.IShoppingCartAPI;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImp implements ISaleService{

    private final ISaleRepository saleRepository;
    private final IShoppingCartAPI shoppingCartAPI;

    public SaleServiceImp(ISaleRepository saleRepository, IShoppingCartAPI shoppingCartAPI) {
        this.saleRepository = saleRepository;
        this.shoppingCartAPI = shoppingCartAPI;
    }
}
