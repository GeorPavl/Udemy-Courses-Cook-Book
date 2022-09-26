package com.tutorials.learnspringframework;

import com.tutorials.learnspringframework.game.GameRunner;
import com.tutorials.learnspringframework.game.MarioGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {

//		SpringApplication.run(LearnSpringFrameworkApplication.class, args);

		MarioGame game = new MarioGame();

		GameRunner runner = new GameRunner(game);

		runner.runGame();
	}

}
