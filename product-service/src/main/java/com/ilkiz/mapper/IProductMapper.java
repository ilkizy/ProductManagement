package com.ilkiz.mapper;

import com.ilkiz.dto.request.SaveRequestDto;
import com.ilkiz.dto.response.CreateStockDto;
import com.ilkiz.dto.response.UpdateStockDto;
import com.ilkiz.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper {

    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    Product toProduct (final SaveRequestDto dto);

    CreateStockDto toCreateStockDto (final Product product);

    UpdateStockDto toUpdateStockDto (final Product product);

}
