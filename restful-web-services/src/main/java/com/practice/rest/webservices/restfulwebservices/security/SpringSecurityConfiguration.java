package com.practice.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//This class would contain  spring beans directly created.So, this is Spring Configuration
@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
//		1. Authenticate all request
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
//		2. If request not authenticated, show a login web page
		http.httpBasic(withDefaults());
		//For the withDefaults() method, search for class Customizer (ctrl,shift,t), it should be in the package -
		// (org.springframework.security.config). From there copy the qualified name of the withDefaults() method and 
		//since the function is static, do a static import.
		
//		3. Disable CSRF
		http.csrf().disable();
		
		return http.build();
	}
}
