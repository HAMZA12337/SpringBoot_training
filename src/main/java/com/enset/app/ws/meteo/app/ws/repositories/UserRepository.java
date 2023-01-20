package com.enset.app.ws.meteo.app.ws.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enset.app.ws.meteo.app.ws.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	
	
	UserEntity findByEmail(String email);
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
