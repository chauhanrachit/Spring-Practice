package com.practice.spring_framework.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {
	
	
	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)) {
			//context.getBean(GamingConsole.class).up();
			//context.getBean(GameRunner.class).run();
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
		} 
	}
}