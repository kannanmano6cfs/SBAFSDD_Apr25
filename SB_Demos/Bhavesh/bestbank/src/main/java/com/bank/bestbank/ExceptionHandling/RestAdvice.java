package com.bank.bestbank.ExceptionHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestAdvice extends ResponseEntityExceptionHandler {

    ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return super.handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
