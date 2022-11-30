package com.masai.Service;

import com.masai.Exception.CustomerException;
import com.masai.Model.Customer;
import com.masai.Model.LoginCustomerDTO;

public interface CustomerService {

	public String RegisterAsCustomer(Customer customer)throws CustomerException;
	
	public String LoginAsCustomer(LoginCustomerDTO dto) throws CustomerException;
	

}
