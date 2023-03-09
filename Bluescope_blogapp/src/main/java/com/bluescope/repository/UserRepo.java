package com.bluescope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluescope.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	  User findByEmail(String email);

}
