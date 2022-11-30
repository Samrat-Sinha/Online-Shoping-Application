package com.masai.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Cart;

public interface CartRepo extends JpaRepository<Cart, String>{

}
