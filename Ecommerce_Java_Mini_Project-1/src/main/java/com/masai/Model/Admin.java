package com.masai.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private String adminId;
	private String FirstName;
	private String LastName;
	private String email;
	private String password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String adminId, String firstName, String lastName, String email, String password) {
		super();
		this.adminId = adminId;
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
