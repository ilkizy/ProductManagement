package com.ilkiz.repository;

import com.ilkiz.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findOptionalByNameAndBrandIgnoreCase(String name, String brand);
    Optional<Product> findOptionalById(Long id);
}
