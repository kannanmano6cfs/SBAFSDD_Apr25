package com.learning.exproductservice.Controller;

import com.learning.exproductservice.Model.Product;
import com.learning.exproductservice.Repository.prdsvcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class prdsvcController {

    @Autowired
    private Environment environment;

    @Autowired
    private prdsvcRepository repo;

    @GetMapping("/welcome")
    public String api() {
        return environment.getProperty("welcome.msg");
    }

    @RequestMapping(path="/index", method= RequestMethod.GET)
    public String index() {
        return "Welcome to Product Service";
    }

    @GetMapping("/count")
    public ResponseEntity<String> count() {
        long count = repo.count();
        return new ResponseEntity<>("Count of product is:"+count, HttpStatus.OK);
    }

    @GetMapping("/getcount")
    public Long getcount()
    {
        return repo.count();
    }

    @GetMapping("/products")
    public Iterable<Product> getProducts() {
     Iterable<Product> products = repo.findAll();
     return products;
    }

    @GetMapping("/getproduct1")
    public Product getProduct1(@RequestParam int id) {
        Optional<Product> product = repo.findById(id);
        return product.orElse(null);
    }

    @GetMapping("/getproduct2/{id}")
    public Product getProduct2(@PathVariable int id) {
        Optional<Product> product = repo.findById(id);
        return product.orElse(null);
    }

    @PostMapping("/addproduct")
    public ResponseEntity<String> addProduct() {
        Product product = new Product();
        product.setPrdname("Apple 14");
        product.setPrdcount("5");
        product.setPrddescription("Applie mobile devices");
        product.setPrdprice("15000");
        repo.save(product);
        return new ResponseEntity<String>("New product added succesfully",HttpStatus.OK);
    }

    @PostMapping("/addproduct1")
    public ResponseEntity<String> addProduct1(@RequestBody Product product) {
        repo.save(product);
        return new ResponseEntity<String>("New product added succesfully through URI",HttpStatus.OK);
    }
}
