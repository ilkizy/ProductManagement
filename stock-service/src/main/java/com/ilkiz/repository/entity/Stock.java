package com.ilkiz.repository.entity;

import com.ilkiz.repository.enums.Cathegory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long productid;
    String name;
    String brand;
    @Enumerated(EnumType.STRING)
    Cathegory cathegory;
    @Builder.Default
    Double quantity = Double.valueOf(0);


}
