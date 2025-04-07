package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.entity.Product;
import com.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public  Product addProduct(Product product) {
		
		Product newproduct=productRepository.save(product);
		return newproduct;
		
	}

	public List<Product> findAll() {
		 return productRepository.findAll();
		
	}
	public Page<Product> getAllProducts(Pageable pageable){
		return productRepository.findAll(pageable);
		
	}

	public Optional<Product> findById(int id) {
	return	productRepository.findById(id);

		
	}
}
