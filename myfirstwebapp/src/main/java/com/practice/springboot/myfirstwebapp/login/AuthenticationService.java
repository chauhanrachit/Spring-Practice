package com.practice.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUserName=username.equalsIgnoreCase("Rachit");
		boolean isValidPassword=password.equalsIgnoreCase("qwerty");
		return isValidUserName && isValidPassword;
	}
}
