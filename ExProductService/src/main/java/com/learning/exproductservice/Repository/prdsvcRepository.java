package com.learning.exproductservice.Repository;

import com.learning.exproductservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface prdsvcRepository extends CrudRepository<Product,Integer> {
}
