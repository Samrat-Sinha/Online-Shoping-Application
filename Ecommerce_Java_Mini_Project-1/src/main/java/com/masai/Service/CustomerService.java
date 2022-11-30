package com.masai.Service;

import java.util.List;

import com.masai.Exception.CartException;
//import com.masai.Exception.CartException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.ProductException;

import com.masai.Model.Customer;
import com.masai.Model.LoginCustomerDTO;
import com.masai.Model.Product;

public interface CustomerService {

	public String RegisterAsCustomer(Customer customer)throws CustomerException;
	
	public String LoginAsCustomer(LoginCustomerDTO dto) throws CustomerException;
	
	public List<Product> ViewAllProduct()throws ProductException;
	
    public List<Product> ViewAllProductByCategory(String productCategory)throws ProductException;
    
    public List<Product> ViewLowToHighByProductPrice()throws ProductException;
    
    public Product viewProductByName(String productName)throws ProductException;
    
    public String addItemtoCart(String productName,Integer cartQuantity)throws CartException;
    
}
