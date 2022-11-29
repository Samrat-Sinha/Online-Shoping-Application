package com.masai.Service;

import com.masai.Exception.CustomerException;
import com.masai.Model.Customer;

public interface CustomerService {

	public String RegisterAsCustomer(Customer customer)throws CustomerException;
}
