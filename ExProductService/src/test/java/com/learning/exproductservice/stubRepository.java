package com.learning.exproductservice;

import com.learning.exproductservice.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface stubRepository extends CrudRepository<Product, Integer> {
}
