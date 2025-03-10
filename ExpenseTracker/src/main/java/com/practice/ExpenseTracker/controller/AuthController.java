package com.practice.ExpenseTracker.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.ExpenseTracker.models.Users;
import com.practice.ExpenseTracker.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/register")
    public String register(@RequestBody Users user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credentials) {
        return authService.authenticate(credentials.get("username"), credentials.get("password"));
    }
	
    @PostMapping("/logout")
    public String logout(@RequestHeader("Authorization") String token) {
        return authService.logout(token.replace("Bearer ", ""));
    }
}
