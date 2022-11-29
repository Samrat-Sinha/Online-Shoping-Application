package com.masai.Service;

import com.masai.Exception.CustomerException;
import com.masai.Model.Customer;
import com.masai.Model.LoginDTO;

public interface CustomerService {

	public String RegisterAsCustomer(Customer customer)throws CustomerException;
	
	public String LoginAsCustomer(LoginDTO dto)throws CustomerException;
	
	public Customer UpdateCustomer(Customer customer,String key)throws CustomerException;
	
	
	
	
	
	
	
	
	public String LogoutAsCustomer(String key)throws CustomerException;
}
