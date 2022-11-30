package com.masai.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CartException;

import com.masai.Exception.CustomerException;
import com.masai.Exception.ProductException;
import com.masai.Model.Cart;

import com.masai.Model.Customer;
import com.masai.Model.CustomerCurrentUserSession;
import com.masai.Model.LoginCustomerDTO;
import com.masai.Model.Product;
import com.masai.Repositary.CartRepo;
import com.masai.Model.ProductDTO;

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
	private ProductRepo CustomerproductRepo;
	
	@Autowired
	CartRepo cartRepo;

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
		
		List<Product> products = CustomerproductRepo.findAll();
		
		if(products.size()!=0) {
			return products;
			
		}
		else {
			throw new ProductException("No Product Is been Added Let the Admin Add some Product First");
		}
		
	}

	@Override
	public List<Product> ViewAllProductByCategory(String productCategory) throws ProductException {
		List<Product> categoryProduct = CustomerproductRepo.findByProductCategory(productCategory);
		
		if(categoryProduct.size()==0) {
			throw new ProductException("No Product Found On this Category");
			
		}
		else {
			return categoryProduct;
		}
	}

	@Override
	public List<Product> ViewLowToHighByProductPrice()throws ProductException{
       
		List<Product> LowtoHighbyPrice = CustomerproductRepo.findAll();
		
		if(LowtoHighbyPrice.size()==0) {
			throw new ProductException("No Product Is been Added Let the Admin Add some Product First");
		}
		else {
			Collections.sort(LowtoHighbyPrice,(a,b)->(a.getProductPrice()>b.getProductPrice()?1:-1));
			return LowtoHighbyPrice;
		}
		
	}

	@Override
	public Product viewProductByName(String productName) throws ProductException {
		Product byName = CustomerproductRepo.findByproductName(productName);
		
		if(byName!=null) {
			return byName;
		}
		else {
			throw new ProductException("This Product is not available");
		}
		
	}

	@Override
	public String addItemtoCart(String productName, Integer cartQuantity) throws CartException {
		
	
		Product productAvailable = CustomerproductRepo.findByproductName(productName);
		
		
		if(productAvailable!=null) {
			
			String idcart = RandomString.make(8);
			Integer finalPrice = cartQuantity * productAvailable.getProductPrice();
			Cart cartToProduct = new Cart(idcart, cartQuantity, new ProductDTO(productAvailable.getProductName(),productAvailable.getProductManufacturer(),finalPrice));
                cartRepo.save(cartToProduct);
                String message = "Product Added to the Cart Successfully";
                return message;
               
		}
		else {
			throw new CartException("This Product is not available");
		}
		
	}	
	
	
}
