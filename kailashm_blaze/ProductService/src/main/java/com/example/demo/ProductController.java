package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    private static final Map<String, Product> productMap = new HashMap<>();
    static {
        productMap.put("1", new Product("1", "Laptop", 999.99));
        productMap.put("2", new Product("2", "Smartphone", 499.99));
        productMap.put("3", new Product("3", "Tablet", 299.99));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
        return ResponseEntity.ok(productMap.get(id));

       
    }
    
    @GetMapping
    public ResponseEntity<Map> getAllProducts() {
        return ResponseEntity.ok(productMap);

       
    }

}
