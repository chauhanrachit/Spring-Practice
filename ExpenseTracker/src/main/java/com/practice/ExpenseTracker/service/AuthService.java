package com.practice.ExpenseTracker.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.ExpenseTracker.models.Users;
import com.practice.ExpenseTracker.repository.UserRepository;
import com.practice.ExpenseTracker.security.JwtUtil;

@Service
public class AuthService {
	
	private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private JwtUtil jwtUtil;

	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}
	
	public String register(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }
    
	public String authenticate(String username, String password) {
		Optional<Users> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            Users user = userOpt.get();
            
            // Create claims for the user
            Map<String, Object> claims = new HashMap<>();
            claims.put("sub", username);
            claims.put("role", user.getRole()); // If role exists in Users entity
            claims.put("iat", System.currentTimeMillis());

            return jwtUtil.generateToken(claims); // Pass claims instead of just username
        }
        throw new RuntimeException("Invalid credentials");
//        Optional<Users> userOpt = userRepository.findByUsername(username);
//        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
//            return jwtUtil.generateToken(username);
//        }
//        throw new RuntimeException("Invalid credentials");
    }
	
	public String logout(String token) {
	    try {
	        jwtUtil.logout(token);
	        return "User logged out successfully";
	    } catch (Exception e) {
	        throw new RuntimeException("Logout failed: " + e.getMessage());
	    }
	}
}
