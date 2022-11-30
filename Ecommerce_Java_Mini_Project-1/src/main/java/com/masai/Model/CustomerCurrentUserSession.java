package com.masai.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerCurrentUserSession {

	@Id
	@Column(unique = true)
	private String userId;
	
	private String uuid;
	
	public CustomerCurrentUserSession() {
		// TODO Auto-generated constructor stub
	}

	public CustomerCurrentUserSession(String userId, String uuid) {
		super();
		this.userId = userId;
		this.uuid = uuid;
	}
	

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
