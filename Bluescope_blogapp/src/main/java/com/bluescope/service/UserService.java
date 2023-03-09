package com.bluescope.service;

import org.springframework.stereotype.Service;

import com.bluescope.entity.CurrentUserSession;
import com.bluescope.entity.User;
import com.bluescope.entity.UserDto;
import com.bluescope.exception.UserException;

@Service
public interface UserService {
	
	public String registerUser(User user) throws UserException;
	
	public CurrentUserSession loginUser(UserDto userdto) throws UserException;
	
}
