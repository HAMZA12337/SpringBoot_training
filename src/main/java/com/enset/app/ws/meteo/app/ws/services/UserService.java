package com.enset.app.ws.meteo.app.ws.services;



import org.springframework.security.core.userdetails.UserDetailsService;

import com.enset.app.ws.meteo.app.ws.dto.UserDto;

public interface UserService extends UserDetailsService {

    UserDto  createUser(UserDto userDto);
	
	
	
	
	
	
	
	
	
	
	
	
}
