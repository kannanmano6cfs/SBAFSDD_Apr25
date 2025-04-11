package com.learning.exgreetingsservice.Controller;

import com.learning.exgreetingsservice.Model.Product;
import com.learning.exgreetingsservice.greetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class greetController {

    @Autowired
    private greetRepository repo;

    @GetMapping("/index")
    public String greet() {
        return "Hello World!! I am running from Container in Docker Desktop";
    }

    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        Iterable<Product> product=repo.findAll();
        return product;
    }

    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct=repo.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

}
