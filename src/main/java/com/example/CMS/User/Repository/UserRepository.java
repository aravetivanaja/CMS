package com.example.CMS.User.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CMS.User.Model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);

	
}
