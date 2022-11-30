package com.masai.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String>{

	public Customer findByCustomerEmail(String customerEmail);
	
}
