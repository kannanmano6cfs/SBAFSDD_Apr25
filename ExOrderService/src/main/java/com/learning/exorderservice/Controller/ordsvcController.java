package com.learning.exorderservice.Controller;

import com.learning.exorderservice.Model.Order;
import com.learning.exorderservice.Model.Product;
import com.learning.exorderservice.Repository.ordsvcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ordsvcController {

    @Autowired
    private ordsvcRepository repo;


    @PostMapping("/placeorder")
    public ResponseEntity<String> placeorder(@RequestBody Product product) {
        Order order = new Order();
        order.setPrdid(product.getId());
        order.setPrdname(product.getPrdname());
        order.setQuantity(1);
        repo.save(order);
        return new ResponseEntity<>("Order placed successfully for the product "+product.getPrdname(), HttpStatus.OK);
    }

}
