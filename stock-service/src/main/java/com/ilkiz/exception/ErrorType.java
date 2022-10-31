package com.ilkiz.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    URUN_ZATEN_KAYITLI(1003,"Bu ürün adı zaten kayıtlı", INTERNAL_SERVER_ERROR),
    //GECERSIZ_TOKEN(1004,"Bu token geçersiz", INTERNAL_SERVER_ERROR),
    URUN_KAYDEDILEMEDI(1005,"Ürün kayıt işlemi başarısız", INTERNAL_SERVER_ERROR),
    URUN_BULUNAMADI(1006,"Ürün bulunamadı", INTERNAL_SERVER_ERROR);


    private int code;
    private String message;
    HttpStatus httpStatus;

}
