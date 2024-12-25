package com.practice.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	//creating Static Block to initialize Static Variable
	static {
		todos.add(new Todo (1,"Rachit","Learn Spring",LocalDate.now().plusYears(1), false) );
		todos.add(new Todo (2,"Rachit","Learn SpringBoot",LocalDate.now().plusYears(2), false) );
		todos.add(new Todo (3,"Rachit","Learn Spring Framework",LocalDate.now().plusYears(3), false) );
		//todos.add(new Todo (4,"Rachit","Learn Spring MVC",LocalDate.now().plusYears(4), false) );
	}
	
	public List<Todo> findByUsername ( String username){
		return todos;
	}
}	
