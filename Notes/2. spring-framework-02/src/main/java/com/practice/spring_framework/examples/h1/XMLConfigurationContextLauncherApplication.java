package com.practice.spring_framework.examples.h1;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.spring_framework.game.GameRunner;

public class XMLConfigurationContextLauncherApplication {
	
	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			context.getBean(GameRunner.class).run();
		} 
	}
}