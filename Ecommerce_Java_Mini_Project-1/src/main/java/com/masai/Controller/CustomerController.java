package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.CartException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.ProductException;
import com.masai.Model.Customer;
import com.masai.Model.LoginCustomerDTO;
import com.masai.Model.Product;
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
	
	@GetMapping("/ProductByCategory/{productCategory}")
	public ResponseEntity<List<Product>> ViewProductByCategory(@PathVariable("productCategory") String productCategory) throws ProductException{
		
		List<Product> byCategory = customerService.ViewAllProductByCategory(productCategory);
		return new ResponseEntity<List<Product>>(byCategory,HttpStatus.OK);
		
	}
	
	@GetMapping("/Low-Price")
	public ResponseEntity<List<Product>> ViewLowtoHighByProductPriceHandler() throws ProductException{
		
		List<Product> lowProductPrice =  customerService.ViewLowToHighByProductPrice();
		
		return new ResponseEntity<List<Product>>(lowProductPrice,HttpStatus.OK);
	}
	
	@GetMapping("/ProductByName/{productName}")
	public ResponseEntity<Product> viewProductByName(@PathVariable("productName") String productName)throws ProductException{
		
		Product productbyName = customerService.viewProductByName(productName);
		return new ResponseEntity<Product>(productbyName,HttpStatus.OK);
	
	}
	
	@PostMapping("/cart/{productName}/{cartQuantity}")
	public ResponseEntity<String> viewAlltoCart(@PathVariable("productName") String productName,@PathVariable("cartQuantity") Integer cartQString) throws CartException{
		
		String addtocart = customerService.addItemtoCart(productName, cartQString);
		
		return new ResponseEntity<String>(addtocart,HttpStatus.CREATED);
	}
	
	
	
}

