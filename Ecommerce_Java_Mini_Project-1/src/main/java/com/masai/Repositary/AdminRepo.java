package com.masai.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin, String>{

}
