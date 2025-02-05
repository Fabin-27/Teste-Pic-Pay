package com.DesafioPicPay.DesafioPicPay.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControleExcessao {

    /*@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity tratatDuplicatas (DataIntegrityViolationException exception){
        return res

    }*/
    
}
