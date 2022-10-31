package com.ilkiz.mapper;

import com.ilkiz.dto.request.SaveRequestDto;
import com.ilkiz.dto.response.CreateStockDto;
import com.ilkiz.dto.response.UpdateStockDto;
import com.ilkiz.repository.entity.Product;
import com.ilkiz.repository.enums.Cathegory;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-31T14:37:23+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (JetBrains s.r.o.)"
)
@Component
public class IProductMapperImpl implements IProductMapper {

    @Override
    public Product toProduct(SaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.name( dto.getName() );
        product.brand( dto.getBrand() );
        if ( dto.getCathegory() != null ) {
            product.cathegory( Enum.valueOf( Cathegory.class, dto.getCathegory() ) );
        }

        return product.build();
    }

    @Override
    public CreateStockDto toCreateStockDto(Product product) {
        if ( product == null ) {
            return null;
        }

        CreateStockDto.CreateStockDtoBuilder createStockDto = CreateStockDto.builder();

        createStockDto.name( product.getName() );
        createStockDto.brand( product.getBrand() );
        createStockDto.cathegory( product.getCathegory() );

        return createStockDto.build();
    }

    @Override
    public UpdateStockDto toUpdateStockDto(Product product) {
        if ( product == null ) {
            return null;
        }

        UpdateStockDto.UpdateStockDtoBuilder updateStockDto = UpdateStockDto.builder();

        return updateStockDto.build();
    }
}
