package com.practice.learn_spring_security.basic;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthSecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		//http.formLogin(withDefaults());
		http.sessionManagement(
					session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				);
		http.httpBasic(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
		return http.build();
		
//		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
//		http.formLogin(withDefaults());
//		http.httpBasic(withDefaults());
//		return http.build();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		var user = User.withUsername("rachit")
//			.password("{noop}pass")
//			.roles("USER")
//			.build();
//		var admin = User.withUsername("admin")
//				.password("{noop}pass")
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user,admin);
//	}
	//For storing User details in the DB --
	//ctrl+shift+t -> go to JdbcDaoImpl class
	//From there we can get DEFAULT_USER_SCHEMA_DDL_LOCATION 
	//(this is the path of a ddl which contains schema for creating a User table in db)
	//And we want it to be executed on startup of our application
	
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
				.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		
		var user = User.withUsername("rachit")
			.password("{noop}pass")
			.roles("USER")
			.build();
		var admin = User.withUsername("admin")
				.password("{noop}pass")
				.roles("ADMIN","USER")
				.build();
		
		var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		jdbcUserDetailsManager.createUser(user);
		jdbcUserDetailsManager.createUser(admin);
		
		return jdbcUserDetailsManager;
	}
}
