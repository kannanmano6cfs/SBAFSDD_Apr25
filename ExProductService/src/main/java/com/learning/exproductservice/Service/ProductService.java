package com.learning.exproductservice.Service;

import com.learning.exproductservice.Model.Product;
import com.learning.exproductservice.Repository.prdsvcRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    final private prdsvcRepository repo;

    public ProductService(prdsvcRepository repo) {
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
