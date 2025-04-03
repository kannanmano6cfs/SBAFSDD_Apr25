package com.learning.exorderservice.Repository;

import com.learning.exorderservice.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ordsvcRepository extends JpaRepository<Order, Integer> {
}
