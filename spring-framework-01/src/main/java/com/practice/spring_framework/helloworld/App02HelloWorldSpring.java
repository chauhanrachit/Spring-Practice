package com.practice.spring_framework.helloworld;

import java.util.Arrays;

import org.springframework.beans.BeansException;
//import com.practice.spring_framework.game.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1: Launch a Spring Context
		
		
		try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			//3: Retrieving Beans managed by Spring
			System.out.println(context.getBean("name"));

			System.out.println(context.getBean("age"));

			System.out.println(context.getBean("person"));

			
			System.out.println(context.getBean("person2MethodCall"));

			System.out.println(context.getBean("person3Parameters"));

			System.out.println(context.getBean("person4Parameters"));

			System.out.println(context.getBean("person5Qualifier"));

			//System.out.println(context.getBean("address2"));

			System.out.println(context.getBean(Address.class));

			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBeanDefinition("person"));

			System.out.println(context.getBeanDefinitionCount());
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		//2: Configure the things that we want Spring to manage - 
		//HelloWorldConfiguration - @Configuration
		//test - @Bean

	
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


