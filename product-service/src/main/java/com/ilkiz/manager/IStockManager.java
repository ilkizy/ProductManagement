package com.ilkiz.manager;

import com.ilkiz.dto.request.SaveRequestDto;
import com.ilkiz.dto.response.CreateStockDto;
import com.ilkiz.dto.response.UpdateStockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.ilkiz.constant.ApiUrls.*;

@FeignClient(name = "stock-manager", url = "http://localhost:8090/api/v1/stock", decode404 = true)
public interface IStockManager {

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody CreateStockDto dto);

    @PostMapping(UPDATESTOCK)
    public  ResponseEntity<Boolean> update(@RequestBody UpdateStockDto dto);


}
