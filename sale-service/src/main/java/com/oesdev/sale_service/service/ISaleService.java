package com.oesdev.sale_service.service;

import com.oesdev.sale_service.dto.SaleDto;

public interface ISaleService {

    String createSale(Long ShoppingCartId);

    SaleDto getSale(Long id);
}
