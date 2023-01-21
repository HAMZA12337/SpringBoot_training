package com.enset.app.ws.meteo.app.ws.services.impl;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.enset.app.ws.meteo.app.ws.dto.UserDto;
import com.enset.app.ws.meteo.app.ws.entities.UserEntity;
import com.enset.app.ws.meteo.app.ws.repositories.UserRepository;
import com.enset.app.ws.meteo.app.ws.services.UserService;
import com.enset.app.ws.meteo.app.ws.shared.Utils;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepositroy;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bcryprPasswordEncoder ;

	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity checkUser=userRepositroy.findByEmail(user.getEmail());
		
		if(checkUser!=null) throw new RuntimeException("User did not exist");
		
		UserEntity userEntity = new UserEntity();
				BeanUtils.copyProperties(user, userEntity);
				
				userEntity.setUserId(utils.generateIdUser(30));
				userEntity.setEncryptedPassword(bcryprPasswordEncoder.encode(user.getPassword()));
				
				
				UserEntity newUser=userRepositroy.save(userEntity);
				UserDto userDto = new UserDto();
		        BeanUtils.copyProperties(newUser, userDto);
		        
	return userDto;}


	








	
	
	
	
	
	
}
