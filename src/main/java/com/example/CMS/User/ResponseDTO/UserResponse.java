package com.example.CMS.User.ResponseDTO;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserResponse {
	
	private int userId;
	private String userName;
	private String email;
	private LocalDateTime createdAt;
	private LocalDateTime lastModifiedAt;
	private boolean deleted;
	
	

	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public UserResponse(int userId, String userName, String email, LocalDateTime createdAt,
			LocalDateTime lastModifiedAt,boolean deleted) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.createdAt = createdAt;
		this.lastModifiedAt = lastModifiedAt;
		this.deleted=deleted;
	}


	public UserResponse() {
		
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getLastModifiedAt() {
		return lastModifiedAt;
	}


	public void setLastModifiedAt(LocalDateTime lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	
	

}
