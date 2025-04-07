package com.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;
	@ValidProductName
	private String prodName;
	@NotEmpty(message="price cannot be empty")
	private String price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Product() {
		super();
	}
	public Product(int id, String prodName, String price) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.price = price;
	}
	
}
