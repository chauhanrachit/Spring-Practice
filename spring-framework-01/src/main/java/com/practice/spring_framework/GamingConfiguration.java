package com.practice.spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practice.spring_framework.game.GameRunner;
import com.practice.spring_framework.game.GamingConsole;
import com.practice.spring_framework.game.PacMan;

@Configuration
public class GamingConfiguration {
	
	@Bean
	public GamingConsole game() {
		var game = new PacMan();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);		
		return gameRunner;
	}
	
	//var game = new MarioGame();
	//var game = new SuperContraGame();

}
