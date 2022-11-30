package com.masai.Model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private String customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerPhone;
	private String customerEmail;
	private String customerPassword;

	@Embedded
	private Address customerAddress;

	

	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public Customer(String customerId, String customerFirstName, String customerLastName, String customerPhone,
			String customerEmail, String customerPassword, Address customerAddress) {
		super();
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerAddress = customerAddress;
	}



    



	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getCustomerFirstName() {
		return customerFirstName;
	}


	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}


	public String getCustomerLastName() {
		return customerLastName;
	}


	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}


	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public String getCustomerPassword() {
		return customerPassword;
	}


	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}


	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}



	
	
	
	
}
