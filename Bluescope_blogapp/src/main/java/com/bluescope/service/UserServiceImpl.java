package com.bluescope.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluescope.entity.CurrentUserSession;
import com.bluescope.entity.User;
import com.bluescope.entity.UserDto;
import com.bluescope.exception.UserException;
import com.bluescope.repository.CurrentUserSessionRepo;
import com.bluescope.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	CurrentUserSessionRepo cusrepo;

	@Override
	public String registerUser(User user) throws UserException {
		Optional<User> checkPresence=userrepo.findById(user.getId());
		if(checkPresence.isPresent()) {
			throw new UserException("User with this id already exist !");
		}
		 userrepo.save(user);
	     return "User registered successfully";
	}

	@Override
	public CurrentUserSession loginUser(UserDto userdto) throws UserException {
		
        User checkUser = userrepo.findByEmail(userdto.getEmail());
		
		if(checkUser == null) {
			throw new UserException("User not found with this email address " + userdto.getEmail());
		}
		
		CurrentUserSession currentSessionUsers = cusrepo.findByEmail(userdto.getEmail());	
		
		if(currentSessionUsers != null) {
			throw new UserException("user already login");
		}
		
		if(!checkUser.getPassword().equals(userdto.getPassword())) {
			
			throw new UserException("Password Wrong ");
		
		}
			
			String key = "abcde";
			
			CurrentUserSession savingCurrentSessionUsers = new CurrentUserSession(checkUser.getId(), checkUser.getEmail(), LocalDate.now(), key);
			
			
		    return cusrepo.save(savingCurrentSessionUsers);
	}

}
