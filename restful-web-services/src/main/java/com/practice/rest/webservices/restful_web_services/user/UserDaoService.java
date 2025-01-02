package com.practice.rest.webservices.restful_web_services.user;

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
	
	static {
		users.add(new User(0, "Rachit",LocalDate.now().minusYears(20)));
		users.add(new User(1, "Rachit1",LocalDate.now().minusYears(21)));
		users.add(new User(2, "Rachit2",LocalDate.now().minusYears(22)));
		users.add(new User(3, "Rachit3",LocalDate.now().minusYears(23)));
	}
	
	public List <User> findAll(){
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}
	
	//public List <User> findAll()
	//public User save(User user)
	//public User findOne(int id)
}
