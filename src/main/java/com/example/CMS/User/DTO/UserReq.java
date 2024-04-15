package com.example.CMS.User.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserReq {
	
	@NotNull(message="enter name")
	private String userName;
	@Email(regexp="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$",message="enter valid email id ")
	private String email;
	//@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$",message="Employee postal code")
	//@Column(nullable=false)
	@NotNull(message="invalid imput")
	private String password;
	
	private boolean deleted;
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserReq(@NotNull(message = "enter name") String userName,
			@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$", message = "enter valid email id ") String email,
			@NotNull(message = "invalid imput") String password, boolean deleted) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.deleted = deleted;
	}
	
	public UserReq()
	{
		
	}
	

}
