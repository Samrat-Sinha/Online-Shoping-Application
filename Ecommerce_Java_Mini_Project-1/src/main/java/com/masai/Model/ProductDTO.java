package com.masai.Model;

public class ProductDTO {

	private String productName;
	private String productManufacturer;
	private Integer productPrice;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String productName, String productManufacturer, Integer productPrice) {
		super();
		this.productName = productName;
		this.productManufacturer = productManufacturer;
		this.productPrice = productPrice;
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

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "ProductDTO [productName=" + productName + ", productManufacturer=" + productManufacturer
				+ ", productPrice=" + productPrice + "]";
	}
	
	
}
