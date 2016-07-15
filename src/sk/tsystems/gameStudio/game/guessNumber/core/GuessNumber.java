package sk.tsystems.gameStudio.game.guessNumber.core;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber implements Runnable{

	Random rnd = new Random();
	Scanner input = new Scanner(System.in);
	private int range;
	private int number;
	private int numberToGuess;

	public GuessNumber(int range) {
		this.range = range;
		this.numberToGuess = rnd.nextInt(range);
	}
	
	public GuessNumber(){
		this(100);
	}

	public int getRange() {
		return range;
	}

	@Override
	public void run() {
			while (!isSolved()) {
				System.out.println("Enter number:");
				number = input.nextInt();
				if (numberToGuess < number) {
					System.out.println("Enter number beetwen 0 and " + range );
					System.out.println("Guess number is too low");
				} else {
					System.out.println("Enter number beetwen 0 and " + range );
					System.out.println("Guess number is too high");
				}
				if (number == -1) {
					return;
				}
			}
		if (isSolved()) {
			System.out.println("You won!!! Congratulation!!!");
		}	
	}

	public boolean isSolved() {
		if (numberToGuess == number) {
			return true;
		} else {
			return false;
		}
	}
}
