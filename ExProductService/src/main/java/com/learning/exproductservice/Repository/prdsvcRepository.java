package com.learning.exproductservice.Repository;

import com.learning.exproductservice.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface prdsvcRepository extends JpaRepository<Product,Integer> {

    //filter by name ignoring case
    Page<Product> findByPrdnameContainingIgnoreCase(String prdname, Pageable pageable);
}
