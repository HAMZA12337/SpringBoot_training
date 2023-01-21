package com.enset.app.ws.meteo.app.ws.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.enset.app.ws.meteo.app.ws.services.UserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
        
	
	
	private final UserService userDetailsService = null;
	private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	http
    	.cors().and()
        .csrf().disable().authorizeHttpRequests()
        .requestMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
        .permitAll()
        .anyRequest().authenticated(); 
    	return http.build();
    }
    // Configure AuthenticationManagerBuilder
    	@Autowired
    	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    	}
    	
     
    
    
    
    
    
    
    
    
}