package com.bank.bestbank.Repository;

import com.bank.bestbank.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface bankRepo  extends CrudRepository<Product,Integer> {
}

