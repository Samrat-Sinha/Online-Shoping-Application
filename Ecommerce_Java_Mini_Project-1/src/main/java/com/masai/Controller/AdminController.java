package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.AdminException;
import com.masai.Exception.ProductException;
import com.masai.Model.Admin;
import com.masai.Model.Product;
import com.masai.Service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/login")
	public ResponseEntity<String> Login_As_Admin_Handler(@RequestBody Admin admin) {
		
		String savedAdmin="";
		try {
			savedAdmin = adminService.LoginAsAdmin(admin);
		} catch (AdminException e) {
			savedAdmin = e.getMessage();
		}
		return new ResponseEntity<String>(savedAdmin,HttpStatus.CREATED);
	}
	
	@PostMapping("/addProducts")
	public ResponseEntity<String> Add_New_Product_Handler(@RequestBody Product product){
		String savedProduct ="";
		
		try {
			savedProduct = adminService.AddProduct(product);
		} catch (ProductException e) {
			savedProduct = e.getMessage();
		}
		return new ResponseEntity<String>(savedProduct,HttpStatus.CREATED);
	}
	
	

	
	
}
