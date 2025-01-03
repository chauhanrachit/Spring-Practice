package com.practice.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}

	//GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//GET /users/{id} -> /users/1
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		User user = service.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id:"+id);
		//while creating the class for above exception super class will be changed from Exception to RuntimeException
		//java.lang.RuntimeException
		//If you extend exception, our exception will become a checked exception, and we want to avoid checked exceptions 
		//most of the time
		
		return user;
	}
	
	//POST /users
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
	//  /users/4 => /users/{id},  user.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri(); 
		//return ResponseEntity.created(null).build();
		//if, after creation of the user, we want to show it
		// we have to give a path to /users/{}
		//Whenever you want to return  a URL of a created resource, there is a specific HTTP headeryou need to make use of
		//that header is called location header -
		// location - /users/4
		//and the created method in ResponseEntity accepts URI Location.
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		service.deleteById(id);
	}
	
}
