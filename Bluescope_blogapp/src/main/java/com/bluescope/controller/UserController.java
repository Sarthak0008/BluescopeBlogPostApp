package com.bluescope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluescope.entity.CurrentUserSession;
import com.bluescope.entity.User;
import com.bluescope.entity.UserDto;
import com.bluescope.exception.UserException;
import com.bluescope.service.UserService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/blogposts")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	 
	
	@PostMapping("/user/register")
	public ResponseEntity<String> addUser(@Valid @RequestBody User user) throws UserException{
		
		String str = this.userservice.registerUser(user);
		
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
		
		
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<CurrentUserSession> loginUser(@RequestBody UserDto userdto) throws  UserException{
		
		CurrentUserSession savecuCurrentSessionUsers = this.userservice.loginUser(userdto);
		
		return new ResponseEntity<CurrentUserSession>(savecuCurrentSessionUsers,HttpStatus.ACCEPTED);
	}

}
