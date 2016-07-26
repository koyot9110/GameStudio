package sk.tsystems.gamestudio.game.consoleui;

import java.util.List;
import java.util.Scanner;

import sk.tsystems.gamestudio.entityjpa.CommentsHibernate;
import sk.tsystems.gamestudio.entityjpa.GameHibernate;
import sk.tsystems.gamestudio.entityjpa.PlayerHibernate;
import sk.tsystems.gamestudio.entityjpa.RatingHibernate;
import sk.tsystems.gamestudio.entityjpa.ScoreHibernate;
import sk.tsystems.gamestudio.service.jpa.CommentJpa;
import sk.tsystems.gamestudio.service.jpa.GameJpa;
import sk.tsystems.gamestudio.service.jpa.PlayerJpa;
import sk.tsystems.gamestudio.service.jpa.RatingJpa;
import sk.tsystems.gamestudio.service.jpa.ScoreJpa;

public class GamesConcoleUI {
	
	Scanner input = new Scanner(System.in);
	
	public void win(String gameName, int trueScore) {
		System.out.println("You won!!! Congratulation!!!");
		System.out.println("Your score is: " + trueScore);
		System.out.println("Enter your name:");
		input = new Scanner(System.in);
		String playerName = input.next();
		
		PlayerHibernate player = new PlayerJpa().checkPlayer(playerName);
		GameHibernate game = new GameJpa().checkGame(gameName);
		
		ScoreHibernate scoreHib = new ScoreHibernate();
		scoreHib.setScore(trueScore);
		scoreHib.setPlayer(player);
		scoreHib.setGame(game);
		
		ScoreJpa sj = new ScoreJpa();
		sj.addScore(scoreHib);

		List<ScoreHibernate> scoreList = sj.printTopTenScore(gameName);
		System.out.println("Score for game: " + gameName);
		for (int i = 0; i < 10; i++) {
			System.out.printf((i+1) + ". " + scoreList.get(i).getPlayer().getPlayerName() + ": " + scoreList.get(i).getScore() + "\n");
		}
		System.out.println();
		rating(playerName, gameName);
		comment(playerName, gameName);
	}

	private void rating(String playerName,String gameName) {
		System.out.println("Do you want rate this game?  Press 'y' for yes");
		input = new Scanner(System.in);
		String option = input.next();
		if (option.equals("y")) {
			
			System.out.println("Please, rate from 0 to 5");
			input = new Scanner(System.in);
			int rate = input.nextInt();
			
			PlayerHibernate player = new PlayerJpa().checkPlayer(playerName);
			GameHibernate game = new GameJpa().checkGame(gameName);
			RatingJpa rj = new RatingJpa();
			
			RatingHibernate ratingHib = new RatingHibernate();
			ratingHib.setRating(rate);
			ratingHib.setPlayer(player);
			ratingHib.setGame(game);
			rj.addRating(ratingHib);
			
			System.out.println("Average is: " + rj.avgRating(gameName));
			System.out.println("Count is: " + rj.countRating(gameName));
		}
	}

	private void comment(String playerName, String gameName) {
		System.out.println("Do you want comment this game? Press 'y' for yes");
		input = new Scanner(System.in);
		String option = input.next();
		if (option.equals("y")) {
			
			System.out.println("Please, enter your comment: ");
			input = new Scanner(System.in);
			String comment = input.nextLine();
			
			PlayerHibernate player = new PlayerJpa().checkPlayer(playerName);
			GameHibernate game = new GameJpa().checkGame(gameName);
			
			CommentsHibernate comHib = new CommentsHibernate();
			comHib.setComment(comment);
			comHib.setPlayer(player);
			comHib.setGame(game);
			
			CommentJpa cj = new CommentJpa();
			cj.addComment(comHib);
			
			List<CommentsHibernate> commentList = cj.printComments(gameName);
			System.out.println("Comments for game: " + gameName);
			for (int i = 0; i < commentList.size(); i++) {
				System.out.println(commentList.get(i).getPlayer().getPlayerName() + ": " + commentList.get(i).getComment());
			}
			System.out.println();
		}
	}
}
