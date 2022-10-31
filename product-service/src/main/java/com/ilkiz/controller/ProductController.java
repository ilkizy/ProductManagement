package com.ilkiz.controller;

import com.ilkiz.dto.request.SaveRequestDto;
import com.ilkiz.dto.request.UpdateRequestDto;
import com.ilkiz.repository.entity.Product;
import com.ilkiz.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.ilkiz.constant.ApiUrls.*;
import java.util.List;

@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(SAVE)
    public ResponseEntity<String> save(@RequestBody SaveRequestDto dto){
        return ResponseEntity.ok(productService.save(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping(UPDATESTOCK)
    public ResponseEntity<String> update( UpdateRequestDto dto){
        return ResponseEntity.ok(productService.updateQuantity(dto));
    }

}
