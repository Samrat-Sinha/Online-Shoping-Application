package com.masai.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private String productId;
	private String productName;
	private String productManufacturer;
	private String productCategory;
	private String productQuantity;
	private Integer productPrice;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productId, String productName, String productManufacturer, String productCategory,
			String productQuantity, Integer productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productManufacturer = productManufacturer;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductManufacturer() {
		return productManufacturer;
	}

	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	
	
	

	
	
}
