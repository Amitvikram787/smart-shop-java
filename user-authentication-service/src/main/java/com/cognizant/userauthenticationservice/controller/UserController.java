package com.cognizant.userauthenticationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.userauthenticationservice.entities.User;
import com.cognizant.userauthenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.userauthenticationservice.service.AppUserDetailsService;

@RestController
public class UserController {
	
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable String id) {
		return appUserDetailsService.getUser(id);
	}
	
	@PostMapping("/users")
	public void signupUser(@RequestBody User user) throws UserAlreadyExistsException {
		appUserDetailsService.signupUser(user);
	}
	
	@PostMapping("/managers")
	public void signupManager(@RequestBody User user) throws UserAlreadyExistsException {
		appUserDetailsService.signupManager(user);
	}
	
	@PostMapping("/admins")
	public void signupAdmin(@RequestBody User user) throws UserAlreadyExistsException {
		appUserDetailsService.signupAdmin(user);
	}
}
