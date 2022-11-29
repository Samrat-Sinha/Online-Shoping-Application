package com.masai.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String>{

}
