package com.practice.spring_framework;

import com.practice.spring_framework.game.*;

public class App01GamingBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//var game = new MarioGame();
		//var game = new SuperContraGame();
		var game = new PacMan();
		
		//1: Object Creation
		
		var gameRunner = new GameRunner(game);
		
		//2: Object Creation + Wiring of Dependencies
		// Game is a Dependency of GameRunner
		
		gameRunner.run();
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


