package com.example.Prasanthdemo.Service;

import com.example.Prasanthdemo.model.product;
import com.example.Prasanthdemo.repository.prdsvcRepository;
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
    public Page<product> getAllProducts(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Page<product> filterProducts(String keyword, Pageable pageable) {
        return repo.findByPrdnameContainingIgnoreCase(keyword,pageable);
    }
}
