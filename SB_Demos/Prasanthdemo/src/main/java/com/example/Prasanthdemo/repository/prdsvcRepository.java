package com.example.Prasanthdemo.repository;

import com.example.Prasanthdemo.model.product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  prdsvcRepository extends JpaRepository<product,Integer> {
    //filter by name ignoring case
    Page<product> findByPrdnameContainingIgnoreCase(String prdname, Pageable pageable);
}
