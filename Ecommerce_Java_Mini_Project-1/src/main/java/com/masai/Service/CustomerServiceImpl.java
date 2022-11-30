package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CustomerException;
import com.masai.Exception.ProductException;
import com.masai.Model.Customer;
import com.masai.Model.CustomerCurrentUserSession;
import com.masai.Model.LoginCustomerDTO;
import com.masai.Model.Product;
import com.masai.Repositary.CustomerCurrentSessionRepo;
import com.masai.Repositary.CustomerRepo;
import com.masai.Repositary.ProductRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CustomerCurrentSessionRepo currentRepo;
	
	@Autowired
	private ProductRepo productRepo;

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
	public String LoginAsCustomer(LoginCustomerDTO dto) throws CustomerException {
		
		Customer  existingCustomer = customerRepo.findByCustomerEmail(dto.getCustomerEmail());
		
		if(existingCustomer==null) {
			throw  new CustomerException("Please Enter a valid Email Address");
		}
		
		Optional<CustomerCurrentUserSession> validCustomerSessionOpt = currentRepo.findById(existingCustomer.getCustomerId());
		
		if(validCustomerSessionOpt.isPresent()) {
			throw new CustomerException("Customer Already Logged In with this Email");
		}
		if(existingCustomer.getCustomerPassword().equals(dto.getCustomerPassword())) {
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
	public List<Product> ViewAllProduct() throws ProductException {
		
		List<Product> products = productRepo.findAll();
		
		if(products.size()!=0) {
			return products;
			
		}
		else {
			throw new ProductException("No Product Is been Added Let the Admin Add some Product First");
		}
		
	}	
	
	
}
