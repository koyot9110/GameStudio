package sk.tsystems.gamestudio.game.consoleui;

import java.util.Scanner;

import sk.tsystems.gamestudio.entity.Comment;
import sk.tsystems.gamestudio.entity.Rating;
import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.service.impl.CommentImpl;
import sk.tsystems.gamestudio.service.impl.GameUtil;
import sk.tsystems.gamestudio.service.impl.PlayerUtil;
import sk.tsystems.gamestudio.service.impl.RatingImpl;
import sk.tsystems.gamestudio.service.impl.ScoreImpl;

public class GamesConcoleUI {
	
	Scanner input = new Scanner(System.in);
	
	public void win(String gameName, int trueScore) {
		System.out.println("You won!!! Congratulation!!!");
		System.out.println("Your score is: " + trueScore);
		System.out.println("Enter your name:");
		input = new Scanner(System.in);
		String name = input.next();
		int playerId = new PlayerUtil().checkName(name);
		int gameId = new GameUtil().checkGame(gameName);
		ScoreImpl scoreimpl = new ScoreImpl();
		Score score = new Score(playerId, gameId, trueScore);
		scoreimpl.addScore(score);
		System.out.println(scoreimpl.printTopTenScore(gameName));
		rating(playerId, gameId, gameName);
		comment(playerId, gameId, gameName);
	}

	private void rating(int playerId, int gameId, String gameName) {
		System.out.println("Do you want rate this game?  Press 'y' for yes");
		input = new Scanner(System.in);
		String option = input.next();
		if (option.equals("y")) {
			System.out.println("Please, rate from 0 to 5");
			input = new Scanner(System.in);
			int rate = input.nextInt();
			Rating rating = new Rating(playerId, gameId, rate);
			RatingImpl ratingimpl = new RatingImpl();
			ratingimpl.addRating(rating);
			System.out.println(ratingimpl.avgRating(gameName));
		}
	}

	private void comment(int playerId, int gameId, String gameName) {
		System.out.println("Do you want comment this game? Press 'y' for yes");
		input = new Scanner(System.in);
		String option = input.next();
		if (option.equals("y")) {
			System.out.println("Please, enter your comment: ");
			input = new Scanner(System.in);
			String comment = input.nextLine();
			Comment com = new Comment(playerId, gameId, comment);
			CommentImpl commentImpl = new CommentImpl();
			commentImpl.addComment(com);
			System.out.println(commentImpl.printComments(gameName));
		}
	}
}
