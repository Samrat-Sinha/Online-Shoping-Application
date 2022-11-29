package com.masai.Service;

import com.masai.Exception.AdminException;
import com.masai.Model.Admin;

public interface AdminService {

	public String RegisterAsAdmin(Admin admin)throws AdminException;
	
}
