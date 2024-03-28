package com.example.CMS.User.ServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.CMS.User.DTO.UserReq;
import com.example.CMS.User.Exception.UserAlreadyExistByEmailException;
import com.example.CMS.User.Model.User;
import com.example.CMS.User.Repository.UserRepository;
import com.example.CMS.User.ResponseDTO.UserResponse;
import com.example.CMS.User.Service.UserService;
import com.example.CMS.User.Utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository ur;
	private ResponseStructure<UserResponse> responseStructure;
	private PasswordEncoder pe;

	public UserServiceImpl(UserRepository ur, ResponseStructure<UserResponse> responseStructure,PasswordEncoder pe) {
		this.ur = ur;
		this.responseStructure = responseStructure;
		this.pe=pe;
	}

	private User mapToUserRequest(UserReq userRequest,User user)
	{
		user.setUserName(userRequest.getUserName());
		user.setEmail(userRequest.getEmail());
		//user.setPassword(userRequest.getPassword());
		user.setPassword(pe.encode(userRequest.getPassword()));
		return user;
	}
	private UserResponse mapToUserResponse(User user)
	{
		UserResponse userResponse=new UserResponse();
				userResponse.setUserId(user.getUserId());
				userResponse.setUserName(user.getUserName());
				userResponse.setEmail(user.getEmail());
				userResponse.setCreatedAt(user.getCreatedAt());
				userResponse.setLastModifiedAt(user.getLastModifiedAt());
				return userResponse;
	}
	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> userRegistration(UserReq userRequest) {
		if(ur.existsByEmail(userRequest.getEmail()))
			throw new UserAlreadyExistByEmailException("Failed to register user");
		return ResponseEntity.ok(responseStructure.setMessage("user registered successfully")
				.setStatusCode(HttpStatus.OK.value())
				.setData(mapToUserResponse(ur.save(mapToUserRequest(userRequest, new User())))));
		 

		
	}
	

}
