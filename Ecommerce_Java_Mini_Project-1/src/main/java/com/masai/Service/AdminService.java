package com.masai.Service;

import com.masai.Exception.AdminException;
import com.masai.Exception.ProductException;
import com.masai.Model.Admin;
import com.masai.Model.Product;

public interface AdminService {

	public String LoginAsAdmin(Admin admin)throws AdminException;
	
	public String AddProduct(Product product)throws ProductException;	
}
