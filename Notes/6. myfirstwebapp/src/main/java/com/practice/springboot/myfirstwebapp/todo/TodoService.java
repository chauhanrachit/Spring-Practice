package com.practice.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount=0;
//	@Autowired
//	private TodoRepository repository;
	//creating Static Block to initialize Static Variable
	static {
		todos.add(new Todo (++todosCount,"Rachit","Learn Spring",LocalDate.now().plusYears(1), false) );
		todos.add(new Todo (++todosCount,"Rachit","Learn SpringBoot",LocalDate.now().plusYears(2), false) );
		todos.add(new Todo (++todosCount,"Rachit","Learn Spring Framework",LocalDate.now().plusYears(3), false) );
		//todos.add(new Todo (4,"Rachit","Learn Spring MVC",LocalDate.now().plusYears(4), false) );
	}
	
	public List<Todo> findByUsername ( String username){
		Predicate<? super Todo> predicate = todo ->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
//		return repository.findByUsername(username);
	}
	
	public void addTodo ( String username, String description, LocalDate targateDate, boolean done){
		todos.addLast(new Todo(++todosCount,username,description,targateDate,done));
//		repository.save(new Todo(++todosCount,username,description,targateDate,done));
	}
	
	public void deleteById (int id){
//		todo.getId()==id
//		 todo ->todo.getId()==id
		Predicate<? super Todo> predicate = todo ->todo.getId()==id;
		todos.removeIf(predicate);
//		repository.deleteById(id);;
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo ->todo.getId()==id;
		return todos.stream().filter(predicate).findFirst().get();
//		return repository.findById(id);
	}

	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
//		repository.save(todo);
		todos.add(todo);
	}
}	
