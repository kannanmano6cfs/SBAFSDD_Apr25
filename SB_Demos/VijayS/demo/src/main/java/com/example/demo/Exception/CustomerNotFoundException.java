package com.example.demo.Exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(int id) {
        super("Customer with id " + id + " not found");
    }
}
