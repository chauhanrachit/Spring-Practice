package com.practice.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	//JPA/Hibernate -> DB
	//For Now -> Static List as DB
	//UserDaoService -. Static List
	
	private static List<User> users = new ArrayList<>();
	private static int usersCount=0;
	
	static {
		users.add(new User(usersCount++, "Rachit",LocalDate.now().minusYears(20)));
		users.add(new User(usersCount++, "Rachit1",LocalDate.now().minusYears(21)));
		users.add(new User(usersCount++, "Rachit2",LocalDate.now().minusYears(22)));
		users.add(new User(usersCount++, "Rachit3",LocalDate.now().minusYears(23)));
	}
	
	public List <User> findAll(){
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		//return users.stream().filter(predicate).findFirst().get();
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(usersCount++);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
	
}
