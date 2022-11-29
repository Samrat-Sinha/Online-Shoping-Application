package com.masai.Model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private String CustomerId;
	private String CustomerFirstName;
	private String CustomerLastName;
	private String CustomerPhone;
	private String CustomerEmail;
	private String CustomerPassword;

	@Embedded
	private Address customerAddress;

	

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	

	public Customer(String customerId, String customerFirstName, String customerLastName, String customerPhone,
			String customerEmail, String customerPassword, Address customerAddress) {
		super();
		CustomerId = customerId;
		CustomerFirstName = customerFirstName;
		CustomerLastName = customerLastName;
		CustomerPhone = customerPhone;
		CustomerEmail = customerEmail;
		CustomerPassword = customerPassword;
		this.customerAddress = customerAddress;
	}



	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getCustomerFirstName() {
		return CustomerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		CustomerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return CustomerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		CustomerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return CustomerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return CustomerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		CustomerPassword = customerPassword;
	}

	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}



	public String getCustomerPhone() {
		return CustomerPhone;
	}



	public void setCustomerPhone(String customerPhone) {
		CustomerPhone = customerPhone;
	}

	
	
	
}
