package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.CustomerException;
import com.masai.Model.Customer;
import com.masai.Service.CustomerService;

@RestController
public class CustomerController{
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<String> RegisterCustomerHandler(@RequestBody Customer customer){
		
		String savedCustomer= "";
		
		try {
			savedCustomer = customerService.RegisterAsCustomer(customer);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<String>(savedCustomer,HttpStatus.CREATED);
	}
	
}

