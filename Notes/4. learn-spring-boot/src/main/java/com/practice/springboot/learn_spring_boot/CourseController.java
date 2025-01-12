package com.practice.springboot.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
				new Course(1,"Learn SpringBoot","Rachit"),
				new Course(2,"Learn SpringFramework","Rachit"),
				new Course(3,"Learn AWS","Rachit")
				);
	}
}
