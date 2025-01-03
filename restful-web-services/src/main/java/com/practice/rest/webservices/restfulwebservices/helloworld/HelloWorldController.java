package com.practice.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//1 To Expose Rest API
@RestController
public class HelloWorldController {
	
	//2 To give a specific URL to this API, Ex - /hello-world
	//3 If someone types this URL, we want to return "Hello World" back
	
	//@RequestMapping(method=RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World" ;
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World") ;
	}
	
	//path parameters
	// /users/{id}/todos/{id} = > /users/2/todos/200
	// /hello-world/path-variable/{name}
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		//return new HelloWorldBean("Hello "+name) ;
		return new HelloWorldBean(String.format("Hello World, %s", name)) ;
	}
	
}
