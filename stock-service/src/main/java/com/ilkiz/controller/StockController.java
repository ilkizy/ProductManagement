package com.ilkiz.controller;

import com.ilkiz.dto.request.CreateStockDto;
import com.ilkiz.dto.request.UpdateStockDto;
import com.ilkiz.repository.entity.Stock;
import com.ilkiz.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ilkiz.constant.ApiUrls.*;

@RestController
@RequestMapping(STOCK)
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody CreateStockDto dto){
        stockService.save(dto);
        return ResponseEntity.ok(true);
    }

    @PostMapping(UPDATESTOCK)
    public ResponseEntity<Boolean> update(@RequestBody UpdateStockDto dto){
        stockService.updateQuantity(dto);
        return ResponseEntity.ok(true);
    }

    @PostMapping(FINDSTOCK)
    public ResponseEntity<Stock> findStock(@RequestBody Long id){
        return ResponseEntity.ok(stockService.findStock(id));
    }
    @PostMapping(FINDPRODUCT)
    public ResponseEntity<List<Stock>> findProduct(String value){
        return ResponseEntity.ok(stockService.findByName(value));
    }
    @PostMapping("/findall")
    public ResponseEntity<List<Stock>> findAll(){
        return ResponseEntity.ok(stockService.findAll());
    }
}
