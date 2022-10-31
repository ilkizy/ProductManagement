package com.ilkiz.service;

import com.ilkiz.dto.request.CreateStockDto;
import com.ilkiz.dto.request.UpdateStockDto;
import com.ilkiz.exception.ErrorType;
import com.ilkiz.exception.StockServiceException;
import com.ilkiz.mapper.IStockMapper;
import com.ilkiz.repository.IStockRepository;
import com.ilkiz.repository.entity.Stock;
import com.ilkiz.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService extends ServiceManager<Stock,Long> {

    private final IStockRepository stockRepository;

    public StockService(IStockRepository stockRepository) {
        super(stockRepository);
        this.stockRepository = stockRepository;
    }

    public Stock save(CreateStockDto dto){
        Stock stock = IStockMapper.INSTANCE.toStock(dto);
        return stockRepository.save(stock);
    }

    public Stock updateQuantity(UpdateStockDto dto){
        Optional<Stock> stock = stockRepository.findOptionalByProductid(dto.getProductid());
        if (stock.isPresent()){
            Double total = dto.getQuantity() + stock.get().getQuantity();
            stock.get().setQuantity(total);
        }else {
            stock.get().setQuantity(dto.getQuantity());
        }
        return stockRepository.save(stock.get());
    }

    public Stock findStock(Long id){
        try {
            Optional<Stock> stock1 = stockRepository.findOptionalByProductid(id);
            return stock1.get();
        }catch (Exception e){
            throw new StockServiceException(ErrorType.URUN_BULUNAMADI);
        }
    }
    public List<Stock> findByName(String value){
        try {
            Optional<List<Stock>> stockList = stockRepository.findAllOptionalByNameContainingIgnoreCase(value);
            return stockList.get();
        }catch (Exception e){
            throw new StockServiceException(ErrorType.URUN_BULUNAMADI);
        }
    }
    public List<Stock> findAll(){
        return stockRepository.findAll();
    }
}
