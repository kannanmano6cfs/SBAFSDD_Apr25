package com.fss.PGProductService.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(ServiceNotFOundException.class)
    public ResponseEntity handleServiceNotFounfException(ServiceNotFOundException ex, WebRequest request)
    {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", ex.getMessage());
        body.put("status", "HttpStatus not found");
        body.put("timestamp", LocalTime.now().toString());
        body.put("path",request.getDescription(false).replace("url=",""));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,WebRequest request)
    {
        Map<String,Object> body=new HashMap<>();
        body.put("message",ex.getMessage());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }


}
