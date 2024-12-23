package com.practice.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.springboot.learnjpaandhibernate.course.Course;
import com.practice.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.practice.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.practice.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
//	@Autowired
//	private CourseJdbcRepository repository;

//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(1,"Learn SpringBoot !!!","Rachit"));
		repository.save(new Course(2,"Learn Spring JPA !!!","Rachit"));
		repository.save(new Course(3,"Learn JPA & Hibernate !!!","Rachit"));
		
		repository.deleteById(1l);
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("Rachit"));

		System.out.println(repository.findByName("Learn Spring JPA !!!"));
	}

}
