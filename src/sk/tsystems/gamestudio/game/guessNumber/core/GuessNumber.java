package sk.tsystems.gamestudio.game.guessNumber.core;

import java.util.Random;
import java.util.Scanner;

import sk.tsystems.gamestudio.game.consoleui.GamesConcoleUI;

public class GuessNumber implements Runnable {

	Random rnd = new Random();
	Scanner input = new Scanner(System.in);
	private int range;
	private int number;
	private int numberToGuess;
	private long startMillis;

	public GuessNumber(int range) {
		this.range = range;
		this.numberToGuess = rnd.nextInt(range);
	}

	public GuessNumber() {
		this(100);
	}

	public int getRange() {
		return range;
	}

	@Override
	public void run() {
		startMillis = System.currentTimeMillis();
		System.out.println("Welcome in game GUESS NUMBER!!!");
		System.out.println("For exit eneter '-1'");
		System.out.println("Enter number between 0 and 100:");
		while (!isSolved()) {
			number = input.nextInt();
			if (numberToGuess < number) {
				System.out.println("Enter number beetwen 0 and " + range + ":");
				System.out.println("Guess number is too low");
			} else if (numberToGuess > number && number >= 0) {
				System.out.println("Enter number beetwen 0 and " + range + ":");
				System.out.println("Guess number is too high");
			}
			if (number == -1) {
				return;
			}
		}
		new GamesConcoleUI().win("GuessNumber", getScore());
	}

	public boolean isSolved() {
		if (numberToGuess == number) {
			return true;
		} else {
			return false;
		}
	}

	public int getPlayingSeconds() {
		return (int) ((System.currentTimeMillis() - startMillis) / 100);
	}
	
	public int getScore() {
		int score = 100000 / getPlayingSeconds();
		return score;
	}
}
