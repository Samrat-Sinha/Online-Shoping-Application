package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AdminException;
import com.masai.Model.Admin;
import com.masai.Repositary.AdminRepo;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public String RegisterAsAdmin(Admin admin)throws AdminException{
		String message = "Admin Already Registered Please Use Login";
		Optional<Admin> opt = adminRepo.findById(admin.getAdminId());
		if(opt.isPresent()) {
			throw new AdminException("Admin Already Registered Please Use Login");
			}
		else {
			adminRepo.save(admin);
			message = "Admin Registered Succesfully";
		}
		return message;
	}

}
