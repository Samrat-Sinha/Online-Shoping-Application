package com.masai.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AdminException;
import com.masai.Exception.ProductException;
import com.masai.Model.Admin;
import com.masai.Model.Product;
import com.masai.Repositary.AdminRepo;
import com.masai.Repositary.ProductRepo;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	
	
	@Override
	public String LoginAsAdmin(Admin admin)throws AdminException{
		String message = "Wrong Admin Credentials";
		
		if(admin.getEmail().equals("admin@gmail.com") && admin.getPassword().equals("password"))
		{
			message = "Admin Login Successfully";
		}
		else {
			throw new AdminException("Wrong Admin Credentials");
		}
		
		return message;
	}

	@Override
	public String AddProduct(Product product) throws ProductException {
		String message  = "Product Already Registered Please add Different Product";
		Optional<Product> opt = productRepo.findById(product.getProductId());
		if(opt.isPresent()) {
			throw new ProductException("Product Already Registered Please add Different Product");
		}
		else {
			productRepo.save(product);
			message = "Product Added By Admin Succesfully";
		}
		return message;
	}


}
