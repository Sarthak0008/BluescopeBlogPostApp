package com.bluescope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluescope.entity.CurrentUserSession;
import com.bluescope.entity.UserDto;

public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession, Integer>{
	
   public CurrentUserSession findByEmail(String email);
	
	public CurrentUserSession findByUUID(String uuid);

}
