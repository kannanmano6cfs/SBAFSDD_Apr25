package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final ProductClient productClient;
    private static final Map<String, Order> orderMap = new HashMap<>();
    
    public OrderController(ProductClient productClient) {
        this.productClient = productClient;
        
        orderMap.put("101", new Order("101", "1", 2)); 
        orderMap.put("102", new Order("102", "2", 1)); 
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetails(@PathVariable("id") String id) {
    	try {
        Order order = orderMap.get(id);
        if (order == null) {
            throw new RuntimeException("Order not found");
        }
        
        Product product = productClient.getProductById(order.getProductId());
        
        Map<String, Object> response = new HashMap<>();
        response.put("orderId", order.getOrderId());
        response.put("product", product);
        response.put("quantity", order.getQuantity());
        response.put("totalPrice", product.getPrice() * order.getQuantity());
        return ResponseEntity.ok(response);
    	}
catch(Exception e) {
	e.printStackTrace();
	 return ResponseEntity.internalServerError().body("Error processing request");
}
        
    }
}