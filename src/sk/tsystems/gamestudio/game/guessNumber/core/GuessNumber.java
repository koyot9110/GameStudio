package sk.tsystems.gamestudio.game.guessNumber.core;

import java.util.Random;
import java.util.Scanner;

import sk.tsystems.gamestudio.entity.Comment;
import sk.tsystems.gamestudio.entity.Rating;
import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.service.impl.CommentImpl;
import sk.tsystems.gamestudio.service.impl.RatingImpl;
import sk.tsystems.gamestudio.service.impl.ScoreImpl;

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
		this(10);
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
			} else {
				System.out.println("Enter number beetwen 0 and " + range + ":");
				System.out.println("Guess number is too high");
			}
			if (number == -1) {
				return;
			}
		}
		win();
	}

	private void win() {
		if (isSolved()) {
			System.out.println("You won!!! Congratulation!!!");
			System.out.println("Enter your name:");
			input = new Scanner(System.in);
			String name = input.next();
			int id = new ScoreImpl().checkName(name);
			ScoreImpl scoreimpl = new ScoreImpl();
			
			System.out.println("idecko"+id);
			
			Score score = new Score(id, 3, getPlayingSeconds());
			scoreimpl.addScore(score);
			System.out.println(scoreimpl.printTopTenScore("GuessNumber"));
			rating(id);
			comment(id);
		}
	}

	private void rating(int id) {
		System.out.println("Do you want rate this game? y/n");
		input = new Scanner(System.in);
		String option = input.next();
		if (option.equals("y")) {
			System.out.println("Please, rate from 0 to 5");
			input = new Scanner(System.in);
			int rate = input.nextInt();
			Rating rating = new Rating(id, 3, rate);
			RatingImpl ratingimpl = new RatingImpl();
			ratingimpl.addRating(rating);
			System.out.println(ratingimpl.avgRating("GuessNumber"));
		}
	}

	private void comment(int id) {
		System.out.println("Do you want comment this game? y/n");
		input = new Scanner(System.in);
		String option = input.next();
		if (option.equals("y")) {
			System.out.println("Please, enter your comment: ");
			input = new Scanner(System.in);
			String comment = input.nextLine();
			Comment com = new Comment(id, 3, comment);
			CommentImpl commentImpl = new CommentImpl();
			commentImpl.addComment(com);
			System.out.println(commentImpl.printComments("GuessNumber"));
		}
	}

	public boolean isSolved() {
		if (numberToGuess == number) {
			return true;
		} else {
			return false;
		}
	}

	public int getPlayingSeconds() {
		return (int) ((System.currentTimeMillis() - startMillis) / 1000);
	}
}
