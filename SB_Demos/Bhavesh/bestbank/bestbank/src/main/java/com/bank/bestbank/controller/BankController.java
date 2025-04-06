package com.bank.bestbank.controller;

import com.bank.bestbank.ExceptionHandling.ProductNotFoundException;
import com.bank.bestbank.Model.Product;
import com.bank.bestbank.Repository.bankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BankController {
    @Autowired
    public bankRepo repo;
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
        Iterable<Product> products1 = repo.findAll();
        return products1;
    }

    @GetMapping("/getproduct1")
    public Product getProduct1(@RequestParam int id) {
        Optional<Product> product = repo.findById(id);
        return product.orElse(null);
    }

    @GetMapping("/getproduct2/{id}")
    public Product getProduct2(@PathVariable int id) {
        Optional<Product> product = repo.findById(id);
        return product.orElseThrow( ()-> new ProductNotFoundException(id));
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

    @PostMapping("/updateproduct/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product product1 = repo.findById(id).orElseThrow();
        product1.setPrdname(product.getPrdname());
        product1.setPrdcount(product.getPrdcount());
        product1.setPrddescription(product.getPrddescription());
        product1.setPrdprice(product.getPrdprice());
        repo.save(product1);
        return new ResponseEntity<>("Product Details updated successfully",HttpStatus.OK);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        repo.deleteById(id);
        return new ResponseEntity<String>("Product deleted successfully",HttpStatus.OK);
    }

}
