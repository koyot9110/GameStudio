package sk.tsystems.gameStudio.menu;

import sk.tsystems.gameStudio.entity.Score;
import sk.tsystems.gameStudio.service.impl.ScoreImpl;

public class Menu {

	public static void main(String[] args) {

//		Game console = new Game();
//		
//		do {
//			console.printMenu();
//			console.runGames();
//		} while (true);
		
		Score df = new Score(22, 2, 15);
		
		ScoreImpl sc = new ScoreImpl();
		sc.addScore(df);
		
	}
}
