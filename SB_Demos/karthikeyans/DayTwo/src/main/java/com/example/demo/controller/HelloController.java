package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, world!";
    }

    @GetMapping("/secure")
    public String secureHello() {
        return "This is a protected resource";
    }

    @GetMapping("/error-test")
    public String throwError() {
        throw new CustomException("This is a manually thrown exception!", HttpStatus.BAD_REQUEST);
    }

}