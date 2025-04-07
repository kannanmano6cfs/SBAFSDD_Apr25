package com.demo.utility;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.demo.exception.ProdcutNotFoundException;

@RestControllerAdvice
public class ProductUtility {
	
	@ExceptionHandler(ProdcutNotFoundException.class)
	public  ResponseEntity handleException(ProdcutNotFoundException e,WebRequest request){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("message", "Product not found");
		map.put("status", HttpStatus.NOT_FOUND.toString());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("Timestamp", LocalDateTime.now().toString());
        body.put("status", HttpStatus.BAD_REQUEST);
        body.put("Error","Input Validation Failed");
        Map<String, Object> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error)->{
            String fieldname=((FieldError)error).getField();
            String errormessage=((FieldError)error).getDefaultMessage();
            errors.put(fieldname,errormessage);
        });
        body.put("Message",errors);
        body.put("path", request.getDescription(false).replace("uri=",""));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
	

}
