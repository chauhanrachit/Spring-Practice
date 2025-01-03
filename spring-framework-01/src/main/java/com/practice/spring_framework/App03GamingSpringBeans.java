package com.practice.spring_framework;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practice.spring_framework.game.*;
import com.practice.spring_framework.helloworld.HelloWorldConfiguration;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
			
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
}


/*
//package com.practice.spring_framework;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SpringFrameworkApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringFrameworkApplication.class, args);
//	}
//
//}
*/


