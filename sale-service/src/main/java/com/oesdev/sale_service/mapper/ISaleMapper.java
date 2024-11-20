package com.oesdev.sale_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ISaleMapper {

    ISaleMapper mapper = Mappers.getMapper(ISaleMapper.class);
}
