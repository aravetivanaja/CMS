package com.example.CMS.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.CMS.User.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	private UserRepository userRepo;
	

	public CustomUserDetailsService(UserRepository userRepo) {

		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepo.findByEmail(username).map(user ->new CustomUserDetails(user)).orElseThrow(()-> new UsernameNotFoundException("username not found"));
				
	}
	//

}
