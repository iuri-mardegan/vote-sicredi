package br.com.sicredi.vote.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(value = 0)
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleException(){
        return ResponseEntity.unprocessableEntity().body("");
    }
}
