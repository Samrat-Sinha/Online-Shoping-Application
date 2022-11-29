package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.AdminException;
import com.masai.Model.Admin;
import com.masai.Service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin")
	public ResponseEntity<String> createBookHandler(@RequestBody Admin admin) {
		
		String savedAdmin="";
		try {
			savedAdmin = adminService.RegisterAsAdmin(admin);
		} catch (AdminException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(savedAdmin,HttpStatus.CREATED);
		
	}
	
}
