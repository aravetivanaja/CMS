package com.example.CMS.User.Service;

import org.springframework.http.ResponseEntity;

import com.example.CMS.User.DTO.UserReq;

import com.example.CMS.User.Model.User;
import com.example.CMS.User.ResponseDTO.UserResponse;
import com.example.CMS.User.Utility.ResponseStructure;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface UserService {
	
	ResponseEntity<ResponseStructure<UserResponse>> userRegistration( UserReq userRequest);

}
