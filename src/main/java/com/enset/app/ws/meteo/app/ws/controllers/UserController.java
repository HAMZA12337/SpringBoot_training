// name space
package com.enset.app.ws.meteo.app.ws.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enset.app.ws.meteo.app.shared.dto.UserDto;
import com.enset.app.ws.meteo.app.ws.requests.UserRequest;
import com.enset.app.ws.meteo.app.ws.responses.UserResponse;


// rest controller called innotation 
@RestController
@RequestMapping("/users") //equivalent localhost/users 
public class UserController {

	
	
	@GetMapping
	public String getUser() {
		
	return "get user was called " ;}
	
	@PostMapping
	public UserResponse createUser(@RequestBody UserRequest userRequest  ) {
		
		
	 UserDto userDto= new UserDto();
     
	 // to create user 
	 // we create this object to return just some attributes(ni password) of dto class
	 BeanUtils.copyProperties(userRequest, userDto);
     UserDto createUser =userService.createuser(userDto);
	 //to create response
     UserResponse userResponse= new UserResponse();
	 BeanUtils.copyProperties(createUser, userResponse);
	
	 return userResponse;
	
	}
	
	@PutMapping
	public String updateUser() {
		
	return "update user was called ";}
	
	@DeleteMapping
	public String deleteUser() {
		
	return "delete user was called ";	
	}
	
	//pascalecase: UserController
	//canalcase   userController
	
}
