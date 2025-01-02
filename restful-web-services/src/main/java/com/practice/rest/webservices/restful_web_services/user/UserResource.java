package com.practice.rest.webservices.restful_web_services.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}

	//GET /users
	@GetMapping(path="/users")
	public List<User>  retrieveAllUsers(){
		return service.findAll();
	}
	
	//GET /users/{id} -> /users/1
	@GetMapping(path="/users/{id}")
	public User retrieveUser(@PathVariable int id){
		return service.findOne(id);
	}
}
