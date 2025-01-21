package com.practice.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// getting -- There was an unexpected error (type=Internal Server Error, status=500).
//Typically when a resource is not found we want the error code 404
//For that @ResponseStatus(code = HttpStatus.NOT_FOUND) annotation
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {

	public PostNotFoundException(String message) {
		super(message);
	}

}
