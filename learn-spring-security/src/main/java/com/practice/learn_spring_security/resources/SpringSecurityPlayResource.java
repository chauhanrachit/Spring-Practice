package com.practice.learn_spring_security.resources;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityPlayResource {

	@GetMapping("/csrf-token")
	public CsrfToken retrieveCsrfToken(HttpServletRequest request) {
		return (CsrfToken)request.getAttribute("_csrf");
	} 
}
//To get csrf token for post requests
//CSRF token might not be applicable if there are no sessions involved, i.e., If Rest API is stateless, 
//in those kind of situations, we might not need to worry about CSRF.
//CSRF is something which is typically tied with the session, with the session cookie
//If we are using a pure stateless REST API, we might want to disable CSRF

//FOr Stateless RESTAPI-- ctrl+shift+t -- search for SBWSC (Which is SpringBootWebSecurityConfiguration)
//From this class we can get the default filter chain 