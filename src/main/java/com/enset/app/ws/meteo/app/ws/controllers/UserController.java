// name space
package com.enset.app.ws.meteo.app.ws.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// rest controller called innotation 
@RestController
@RequestMapping("/users") //equivalent localhost/users 
public class UserController {

	
	
	@GetMapping
	public String getUser() {
		
	return "get user was called " ;}
	
	@PostMapping
	public String createUser() {
		
		return "Create user was called " ;}
	
	@PutMapping
	public String updateUser() {
		
	return "update user was called ";}
	
	@DeleteMapping
	public String deleteUser() {
		
	return "delete user was called ";	
	}
	
	
	
}
