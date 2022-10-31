package com.ilkiz.service;

import com.ilkiz.dto.request.SaveRequestDto;
import com.ilkiz.dto.request.UpdateRequestDto;
import com.ilkiz.dto.response.CreateStockDto;
import com.ilkiz.dto.response.UpdateStockDto;
import com.ilkiz.exception.ErrorType;
import com.ilkiz.exception.ProductServiceException;
import com.ilkiz.manager.IStockManager;
import com.ilkiz.mapper.IProductMapper;
import com.ilkiz.repository.IProductRepository;
import com.ilkiz.repository.entity.Product;
import com.ilkiz.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends ServiceManager<Product,Long> {

    private final IProductRepository productRepository;
    private final IStockManager stockManager;

    public ProductService(IProductRepository productRepository, IStockManager stockManager) {
        super(productRepository);
        this.productRepository = productRepository;
        this.stockManager = stockManager;
    }

    public String save(SaveRequestDto dto){

        Optional<Product> product = productRepository.findOptionalByNameAndBrandIgnoreCase(dto.getName(), dto.getBrand());
        if (product.isPresent()) throw new ProductServiceException(ErrorType.URUN_ZATEN_KAYITLI);

        try {
            product = Optional.ofNullable(IProductMapper.INSTANCE.toProduct(dto));
            save(product.get());
            stockManager.save(CreateStockDto.builder()
                    .cathegory(product.get().getCathegory())
                    .productid(product.get().getId())
                    .name(product.get().getName())
                    .brand(product.get().getBrand())
                    .build());
            return "Ürün kaydedildi";
        }catch (Exception e){
            throw new ProductServiceException(ErrorType.URUN_KAYDEDILEMEDI);
        }

    }

    public String updateQuantity(UpdateRequestDto dto){
        Optional<Product> product = productRepository.findOptionalById(dto.getId());
        if (product.isPresent()){
            stockManager.update(UpdateStockDto.builder()
                    .quantity(dto.getQuantity())
                    .productid(dto.getId())
                    .build());
        }
        return "Stok güncellendi";
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
