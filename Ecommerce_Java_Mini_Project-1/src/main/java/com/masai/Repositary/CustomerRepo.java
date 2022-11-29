package com.masai.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Customer;
import com.masai.Model.CustomerCurrentUserSession;

public interface CustomerRepo extends JpaRepository<Customer, String>{

	public Customer findByEmailId(String customerEmail);
}
