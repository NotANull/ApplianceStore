package com.oesdev.shoppingCart_service.mapper;

import com.oesdev.shoppingCart_service.dto.ProductDto;
import com.oesdev.shoppingCart_service.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IShoppingCartMapper {

    IShoppingCartMapper mapper = Mappers.getMapper(IShoppingCartMapper.class);

    Product toEntity(ProductDto productDto);

}
