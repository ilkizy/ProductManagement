package com.ilkiz.mapper;

import com.ilkiz.dto.request.CreateStockDto;
import com.ilkiz.dto.request.UpdateStockDto;
import com.ilkiz.repository.entity.Stock;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-31T14:47:27+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (JetBrains s.r.o.)"
)
@Component
public class IStockMapperImpl implements IStockMapper {

    @Override
    public Stock toStock(CreateStockDto dto) {
        if ( dto == null ) {
            return null;
        }

        Stock.StockBuilder stock = Stock.builder();

        stock.productid( dto.getProductid() );
        stock.name( dto.getName() );
        stock.brand( dto.getBrand() );
        stock.cathegory( dto.getCathegory() );

        return stock.build();
    }

    @Override
    public Stock toStock(UpdateStockDto dto) {
        if ( dto == null ) {
            return null;
        }

        Stock.StockBuilder stock = Stock.builder();

        stock.productid( dto.getProductid() );
        stock.quantity( dto.getQuantity() );

        return stock.build();
    }
}
