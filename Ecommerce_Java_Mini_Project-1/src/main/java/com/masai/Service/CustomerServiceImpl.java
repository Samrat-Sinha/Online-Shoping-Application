package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CustomerException;
import com.masai.Model.Customer;
import com.masai.Model.CustomerCurrentUserSession;
import com.masai.Model.LoginDTO;
import com.masai.Repositary.CustomerCurrentSessionRepo;
import com.masai.Repositary.CustomerRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
    private CustomerCurrentSessionRepo currentRepo;
	
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

	

	@Override
	public Customer UpdateCustomer(Customer customer, String key) throws CustomerException {
		
		CustomerCurrentUserSession loggedInUser = currentRepo.findByUuid(key);
		
		if(loggedInUser==null) {
			throw new CustomerException("Please provide a valid Key to Update the Customer");
		}
		
		if(customer.getCustomerId()==loggedInUser.getUserId()){
	         return customerRepo.save(customer);
		}
		else {
			throw new CustomerException("Invalid Customer Details, Please Login First");
		}
	}



	@Override
	public String LoginAsCustomer(LoginDTO dto) throws CustomerException {
		
		Customer  existingCustomer = customerRepo.findByEmailId(dto.getEmail()); 
		
		if(existingCustomer==null) {
			throw new CustomerException("Please Enter a valid Email Address");
		}
	   
	    Optional<CustomerCurrentUserSession> validCustomerSessionOpt = currentRepo.findById(existingCustomer.getCustomerId());
	
	    if(validCustomerSessionOpt.isPresent()) {
	    	throw new CustomerException("Customer Already Logged In with this Email");
	    }
	    if(existingCustomer.getCustomerPassword().equals(dto.getPassword())) {
	    	String key = RandomString.make(6);
	    	
	    	CustomerCurrentUserSession current = new CustomerCurrentUserSession(existingCustomer.getCustomerId(),key);
	    	
	    	currentRepo.save(current);
	    	return current.toString();
	    }
	    else {
	    	throw new CustomerException("Please Enter The Correct Password");
	    }
	}



	@Override
	public String LogoutAsCustomer(String key) throws CustomerException {
		CustomerCurrentUserSession validCustomerCurrentUserSession = currentRepo.findByUuid(key);
		
		if(validCustomerCurrentUserSession==null) {
			throw new CustomerException("Customer Not Logged In with this Email");
		}
		currentRepo.delete(validCustomerCurrentUserSession);
		return "Logged Out Successfull By customer";
	}

	
}
