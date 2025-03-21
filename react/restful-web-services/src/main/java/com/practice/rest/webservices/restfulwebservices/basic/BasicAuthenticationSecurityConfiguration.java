package com.practice.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//1: Response to preflight request doesn't pass access control check 
		//2: Basic auth 
		return 
				http.authorizeHttpRequests(	
						auth -> auth
//							.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
							.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
							.anyRequest().authenticated()	
						)
					.httpBasic(Customizer.withDefaults())
					.sessionManagement(	session -> session.sessionCreationPolicy ( SessionCreationPolicy.STATELESS)	)
					.csrf().disable()
					.build();	
	}
}
