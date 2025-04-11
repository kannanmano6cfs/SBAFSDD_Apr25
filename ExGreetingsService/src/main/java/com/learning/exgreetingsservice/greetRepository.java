package com.learning.exgreetingsservice;

import com.learning.exgreetingsservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface greetRepository extends JpaRepository<Product, Integer> {

}
