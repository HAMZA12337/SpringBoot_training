package com.enset.app.ws.meteo.app.ws.services.impl;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enset.app.ws.meteo.app.ws.dto.UserDto;
import com.enset.app.ws.meteo.app.ws.entities.UserEntity;
import com.enset.app.ws.meteo.app.ws.repositories.UserRepository;
import com.enset.app.ws.meteo.app.ws.services.UserService;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepositroy;
	

	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity checkUser=userRepositroy.findByEmail(user.getEmail());
		
		if(checkUser!=null) throw new RuntimeException("User did not exist");
		
		UserEntity userEntity = new UserEntity();
				BeanUtils.copyProperties(user, userEntity);
				
				
				userEntity.setEncryptedPassword("dddd");
				userEntity.setUserId("ddd");
				
				UserEntity newUser=userRepositroy.save(userEntity);
				UserDto userDto = new UserDto();
		        BeanUtils.copyProperties(newUser, userDto);
		        
	return userDto;}


	








	
	
	
	
	
	
}
