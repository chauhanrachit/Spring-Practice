package com.practice.spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
	private GamingConsole game;// 	SuperContraGameQualifier
	
//	public GameRunner(@Qualifier("superContraGame") GamingConsole game) {
	public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
		// TODO Auto-generated constructor stub
		this.game = game;
		//run();
	}
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running game : " + game );
		game.up();
		game.down();
		game.left();
		game.right();
	}

}
