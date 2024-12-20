package com.practice.spring_framework.game;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.practice.spring_framework.game")
public class GamingAppLauncherApplication {
	
	
	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
			//context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
						
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
}