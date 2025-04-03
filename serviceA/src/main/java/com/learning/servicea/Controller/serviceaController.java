package com.learning.servicea.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class serviceaController {

    @Autowired
    private Environment env;
    @GetMapping("/servicea")
    public String hello() {
        return "Hello!! This is from ServiceA on port "+env.getProperty("server.port");
    }

}
