package com.masai.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.CustomerException;
import com.masai.Exception.ProductException;
import com.masai.Model.Customer;
import com.masai.Model.LoginCustomerDTO;
import com.masai.Model.Product;
//import com.masai.Model.LoginDTO;
import com.masai.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController{
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/Register")
	public ResponseEntity<String> RegisterCustomerHandler(@RequestBody Customer customer){
		String savedCustomer= "";
		try {
			savedCustomer = customerService.RegisterAsCustomer(customer);
		} catch (CustomerException e) {
			savedCustomer = e.getMessage();
		}
		return new ResponseEntity<String>(savedCustomer,HttpStatus.CREATED);
	}

	@PostMapping("/Customerlogin")
	public ResponseEntity<String> logInCustomer(@RequestBody LoginCustomerDTO dto) throws CustomerException {
		
		String result = customerService.LoginAsCustomer(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@GetMapping("/AllProduct")
	public ResponseEntity<List<Product>> ViewAllProduct() throws ProductException{
		
		List<Product> Products =  customerService.ViewAllProduct();
		
		return new ResponseEntity<List<Product>>(Products,HttpStatus.OK);
	}
	
}

