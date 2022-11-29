package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CustomerException;
import com.masai.Model.Customer;
import com.masai.Repositary.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public String RegisterAsCustomer(Customer customer) throws CustomerException {
		
		
		String message = "Customer Already Registered Please Use Login";
		Optional<Customer> opt = customerRepo.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			throw new CustomerException("Customer Already Registered Please Use Login");
			}
		else {
			customerRepo.save(customer);
			message = "Customer Registered Succesfully";
		}
		return message;
		
		
	}

	
}
