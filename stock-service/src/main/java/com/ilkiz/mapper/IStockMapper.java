package com.ilkiz.mapper;

import com.ilkiz.dto.request.CreateStockDto;
import com.ilkiz.dto.request.UpdateStockDto;
import com.ilkiz.repository.entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IStockMapper {

    IStockMapper INSTANCE = Mappers.getMapper(IStockMapper.class);

    Stock toStock(final CreateStockDto dto);
    Stock toStock(final UpdateStockDto dto);
}
