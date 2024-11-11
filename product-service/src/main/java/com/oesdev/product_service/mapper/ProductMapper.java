package com.oesdev.product_service.mapper;

import com.oesdev.product_service.dto.request.ProductRequestDto;
import com.oesdev.product_service.dto.response.ProductResponseDto;
import com.oesdev.product_service.entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductFromDto(ProductRequestDto productRequestDto, @MappingTarget Product product);
}

