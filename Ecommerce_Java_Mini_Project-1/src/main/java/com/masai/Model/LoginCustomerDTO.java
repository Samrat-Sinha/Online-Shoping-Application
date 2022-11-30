package com.masai.Model;

public class LoginCustomerDTO {

	private String CustomerEmail;
	private String customerPassword;
	
	public LoginCustomerDTO() {
		// TODO Auto-generated constructor stub
	}

	public LoginCustomerDTO(String customerEmail, String customerPassword) {
		super();
		CustomerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}

	public String getCustomerEmail() {
		return CustomerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

		
	
}
