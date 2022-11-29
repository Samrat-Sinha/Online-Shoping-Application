package com.masai.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerCurrentUserSession {

	@Id
	@Column(unique = true)
	private String UserId;
	
	private String uuid;
	
	public CustomerCurrentUserSession() {
		// TODO Auto-generated constructor stub
	}

	

	public CustomerCurrentUserSession(String userId, String uuid) {
		super();
		UserId = userId;
		this.uuid = uuid;
	}



	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	
}
