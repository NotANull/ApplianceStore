package com.oesdev.shoppingCart_service.mapper;

import com.oesdev.shoppingCart_service.dto.ProductDto;
import com.oesdev.shoppingCart_service.dto.ShoppingCartDto;
import com.oesdev.shoppingCart_service.entity.Product;
import com.oesdev.shoppingCart_service.entity.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IShoppingCartMapper {

    IShoppingCartMapper mapper = Mappers.getMapper(IShoppingCartMapper.class);

    Product toEntity(ProductDto productDto);

    ShoppingCartDto toDto(ShoppingCart shoppingCart);

}
