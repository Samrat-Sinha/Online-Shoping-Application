package com.masai.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, String>{

}
