package com.practice.springboot.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
//	Typlically, whenever we want to store Usernames and/or Password  we use LDAP or DB
//	To keep things simple, here we will use In Memory Configure

//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails... users)

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = createNewUser("Rachit", "qwerty");
		UserDetails userDetails2 = createNewUser("dummy", "dummy");

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {

		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder)
//									.withDefaultPasswordEncoder()
				.username(username).password(password).roles("USER", "ADMIN").build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	By default, if we have not logged in, and try to open any url Ex - welcome, listTodos, todo etc. it will all be redirected to 
//	login page, because all pages are being protected by spring security be default
//	To access H2 console, we will need to disable CSRF (Cross Site Request Forgery)
//	H2 Sites make use of Frames, and Spring Security by default, does not allow frames.So we need to make sure that frames are also 
//	allowed.To configure all of these things - 

//	Defines a filter chain matched against every request
//	When we override SecurityFilterChain, we need to define entire chain again!!!!
	@SuppressWarnings("removal")//not needed, just added because warning was not looking good
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//		TO get withDefaults(), we need to do a static import, Ctrl+shift+t search 'customizer' and open interface - 
//		 with 'org.springframework.security.config' path and copy qualified name of the interface Customizer<T> 
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
//		X-Frame-Options enabled ==> Frames cannot be used
//		h2-console uses frames ==>  Disable X-Frame-Options header
		return http.build();
		
//		Flow of this function-
//		http.authorizeHttpRequests - TO ensure all requests are authenticated
//		formLogin - If there is an unauthorized Request, then we are configuring formLogin(), so that we can show a page, where we
//		can collect the username and password
//		csrf().disable() - Disabling CSRF
//		headers().frameOptions().disable() - and enabling use of frames on our application
	}

}
