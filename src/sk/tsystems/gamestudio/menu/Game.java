package sk.tsystems.gamestudio.menu;

import java.util.Scanner;

import sk.tsystems.gamestudio.game.guessNumber.core.GuessNumber;
import sk.tsystems.gamestudio.game.minesweeper.Minesweeper;
import sk.tsystems.gamestudio.game.stones.Stone;

public class Game {
	
	private Scanner scanner = new Scanner(System.in);
	
	public void printMenu() {
		System.out.println("-------------------------------------------------------------");
		System.out.println("-------------------Welcome in Game Studio--------------------");
		System.out.println("-------------------------------------------------------------");
		System.out.println("-------------Please enter number to choose game--------------");
		System.out.println("--------------------------1. STONES--------------------------");
		System.out.println("------------------------2. MINESWEEPER-----------------------");
		System.out.println("-----------------------3. GUESS NUMBER-----------------------");
		System.out.println("-------------------------------------------------------------");
		System.out.println("---------------------Please enter number:--------------------");
		System.out.println("-------------------------------------------------------------");
	}
	
	public void runGames() {
		
		int key = scanner.nextInt();
		
		switch (key) {
		case 1:
			Stone stone = new Stone();
			stone.run();
			break;
		case 2:
			new Minesweeper().run();
			break;
		case 3:
			System.out.println("Welcome in game GUESS NUMBER!!!");
			System.out.println("For exit eneter '-1'");
			System.out.println("Please enter range for game:");
			int range = scanner.nextInt();
			GuessNumber gn = new GuessNumber(range);
			System.out.println("Enter number beetwen 0 and " + range );
			gn.run();
			break;
		default:
			break;
		}
	}
}
