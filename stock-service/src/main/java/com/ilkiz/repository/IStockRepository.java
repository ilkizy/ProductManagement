package com.ilkiz.repository;

import com.ilkiz.repository.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStockRepository extends JpaRepository<Stock,Long> {

    Optional<Stock> findOptionalByProductid(Long productid);
   Optional<List<Stock>> findAllOptionalByNameContainingIgnoreCase(String name);


}
