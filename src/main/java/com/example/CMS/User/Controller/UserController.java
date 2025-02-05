package com.example.CMS.User.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CMS.User.DTO.UserReq;

import com.example.CMS.User.Model.User;
import com.example.CMS.User.ResponseDTO.UserResponse;
import com.example.CMS.User.Service.UserService;
import com.example.CMS.User.Utility.ResponseStructure;


import lombok.AllArgsConstructor;

@RestController
public class UserController {
	
	private UserService us;

	public UserController(UserService us) {
		super();
		this.us = us;
	}
	
	@PostMapping(value="/users/register")
	public ResponseEntity<ResponseStructure<UserResponse>> userRegistration(@RequestBody UserReq userRequest)
	{
		
		return us.userRegistration(userRequest);

	}
	
	@GetMapping(value="/test")
	public String test()
	{
		return "hello from cms";
	}
}

