package com.masai.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.CustomerCurrentUserSession;

public interface CustomerCurrentSessionRepo extends JpaRepository<CustomerCurrentUserSession, String>{

	public CustomerCurrentUserSession findByUuid(String uuid);
}
