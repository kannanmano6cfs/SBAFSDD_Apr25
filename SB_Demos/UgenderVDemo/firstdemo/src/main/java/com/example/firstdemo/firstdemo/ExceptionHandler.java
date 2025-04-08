package com.example.firstdemo.firstdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NotfoundException.class)
    public ResponseEntity response(NotfoundException notfoundException, WebRequest webRequest){

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", notfoundException.getMessage());
        body.put("status", "HttpStatus not found");
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("path", webRequest.getDescription(false).replace("uri=",""));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);

    }
}
