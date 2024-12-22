package com.practice.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.springboot.learnjpaandhibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private CourseJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.insert(new Course(1,"Learn Spring !!!","Rachit"));
		repository.insert(new Course(2,"Learn SpringBoot !!!","Rachit"));
		repository.insert(new Course(3,"Learn JPA & Hibernate !!!","Rachit"));
		
		repository.deleteById(1);
		System.out.println(repository.findById(2));
		System.out.println(repository.findById(3));

	}

}
