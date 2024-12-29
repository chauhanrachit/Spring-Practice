package com.practice.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//First value is what bean should it manage, and the second is Type of the Id field
public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	List<Todo> findByUsername (String username);
//	
//	List<Course> findByName (String name);
}
