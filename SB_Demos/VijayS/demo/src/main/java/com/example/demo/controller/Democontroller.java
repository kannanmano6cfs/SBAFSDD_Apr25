package com.example.demo.controller;

import com.example.demo.Exception.CustomerNotFoundException;
import com.example.demo.model.customer;
import com.example.demo.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class Democontroller {
    @Autowired
    private customerRepository repo;
    @GetMapping("/cusdetails")
    public Iterable<customer> getProducts() {
        Iterable<customer> customer = repo.findAll();
        return customer;
    }
    @PostMapping("/addcustomer")
    public ResponseEntity<String> addProduct1(@RequestBody customer cus) {
        repo.save(cus);
        return new ResponseEntity<String>("New customer Details added succesfully through URI", HttpStatus.OK);
    }

    //Exception handling
    @GetMapping("/customerDetails/{id}")
    public customer getProduct2(@PathVariable int id) {
        Optional<customer> product = repo.findById(id);
        return product.orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @DeleteMapping("/deletecustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
        return new ResponseEntity<String>("Customer deleted successfully",HttpStatus.OK);
    }
}
