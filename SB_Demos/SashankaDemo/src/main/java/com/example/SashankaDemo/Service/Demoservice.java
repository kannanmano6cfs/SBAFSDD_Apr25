package com.example.SashankaDemo.Service;

import com.example.SashankaDemo.Model.Product;
import com.example.SashankaDemo.Repository.prdsvcRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class Demoservice {

     final private prdsvcRepository repo;

    public Demoservice(prdsvcRepository repo) {
        this.repo = repo;
    }

    //service created fr pagination
    public Page<Product> getAllProducts(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Page<Product> filterProducts(String keyword, Pageable pageable) {
        return repo.findByPrdnameContainingIgnoreCase(keyword,pageable);
    }
}
