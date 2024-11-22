package com.oesdev.sale_service.mapper;

import com.oesdev.sale_service.dto.SaleDto;
import com.oesdev.sale_service.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ISaleMapper {

    ISaleMapper mapper = Mappers.getMapper(ISaleMapper.class);

    SaleDto toDto(Sale sale);
}
