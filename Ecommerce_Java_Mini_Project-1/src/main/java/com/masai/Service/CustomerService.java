package com.masai.Service;

import java.util.List;

import com.masai.Exception.CustomerException;
import com.masai.Exception.ProductException;
import com.masai.Model.Customer;
import com.masai.Model.LoginCustomerDTO;
import com.masai.Model.Product;

public interface CustomerService {

	public String RegisterAsCustomer(Customer customer)throws CustomerException;
	
	public String LoginAsCustomer(LoginCustomerDTO dto) throws CustomerException;
	
	public List<Product> ViewAllProduct()throws ProductException;
	

}
