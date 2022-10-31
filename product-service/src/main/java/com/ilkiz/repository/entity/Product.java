package com.ilkiz.repository.entity;

import com.ilkiz.repository.enums.Cathegory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String brand;
    @Enumerated(EnumType.STRING)
    Cathegory cathegory;
    Long productionDate;
    Long expiredDate;

}
