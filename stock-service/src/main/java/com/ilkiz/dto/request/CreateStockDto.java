package com.ilkiz.dto.request;

import com.ilkiz.repository.enums.Cathegory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateStockDto {

    Long productid;
    String name;
    String brand;
    Cathegory cathegory;
}
