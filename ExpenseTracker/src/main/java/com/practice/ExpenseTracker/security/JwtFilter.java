package com.practice.ExpenseTracker.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private JwtUtil jwtUtil;
	private CustomUserDetailsService userDetailsService;

	public JwtFilter(JwtUtil jwtUtil, CustomUserDetailsService userDetailsService) {
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		
		//System.out.println("request - ");
		
		//System.out.println(request);
		
		//System.out.println("authheader: "+authHeader);
		
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			System.err.println("Authorization header is missing or does not start with 'Bearer '");
			chain.doFilter(request, response);
			return;
		}
		
		String token = authHeader.substring(7);
		//System.out.println("Extracted JWT Token: " + token); // Debugging log
		
		try {
			String username = jwtUtil.extractUsername(token);
			//System.out.println("jwtUtil.extractUsername(token)- "+ username );
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			if (jwtUtil.validateToken(token, userDetails.getUsername())) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		} catch (JwtException e) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT Token");
			return;
		}

		chain.doFilter(request, response);
	}
}
