package com.masai.Model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	private String CartId;
	private Integer cartQuantity;
	
	@Embedded
	private ProductDTO productCart;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(String cartId, Integer cartQuantity, ProductDTO productCart) {
		super();
		CartId = cartId;
		this.cartQuantity = cartQuantity;
		this.productCart = productCart;
	}

	public String getCartId() {
		return CartId;
	}

	public void setCartId(String cartId) {
		CartId = cartId;
	}

	public Integer getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(Integer cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public ProductDTO getProductCart() {
		return productCart;
	}

	public void setProductCart(ProductDTO productCart) {
		this.productCart = productCart;
	}

	@Override
	public String toString() {
		return "Cart [CartId=" + CartId + ", cartQuantity=" + cartQuantity + ", productCart=" + productCart + "]";
	}
	
}
