package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Product;
import com.demo.exception.ProdcutNotFoundException;
import com.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class DemoController {
	
	@Autowired
	private ProductService prodService;
	
	@PostMapping("/addProducts")
	public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product){
		Product newproduct=prodService.addProduct(product);
		
		return new ResponseEntity(newproduct, HttpStatus.OK);
	}
	@GetMapping("/getProducts")
	public ResponseEntity<Page<Product>> getProducts(@PageableDefault(size=2) Pageable pageable){
//		Iterator iterator=(Iterator)prodService.findAll().iterator();
		
		return new ResponseEntity<Page<Product>>(prodService.getAllProducts(pageable),HttpStatus.OK);
	}
	
	@GetMapping("/getProduct/{Id}")
	public Product getProductById( @PathVariable  int Id) throws Exception{
		Optional<Product> product=prodService.findById( Id);
		
		return product.orElseThrow(()-> new ProdcutNotFoundException());
	}
	
	

}
