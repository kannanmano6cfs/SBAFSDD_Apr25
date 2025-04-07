package com.example.SashankaDemo.Repository;

import com.example.SashankaDemo.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface prdsvcRepository extends JpaRepository<Product,Integer> {

    //filter by name ignoring case
    Page<Product> findByPrdnameContainingIgnoreCase(String prdname, Pageable pageable);
}
