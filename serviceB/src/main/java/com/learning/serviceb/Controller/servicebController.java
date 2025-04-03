package com.learning.serviceb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class servicebController {

    @GetMapping("/serviceb")
    public String hello() {
        return "Hello!! This is from ServiceB!";
    }

}
