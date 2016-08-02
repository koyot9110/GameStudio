package sk.tsystems.gamestudio.menu;

import java.util.List;

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

public class Menu {

	public static void main(String[] args) {

		MenuUI console = new MenuUI();
		
		do {
			console.printMenu();
			console.runGames();
		} while (true);
		
		
//		CommentJpa cj = new CommentJpa();
//		
//		List<Comments> pismo = cj.printComments("Stones");
//
//		for (int i = 0; i < pismo.size(); i++) {
//			System.out.println(pismo.get(i).getComment());
//		}
		
//		String gameName = "GuessNumber";
//
//		RatingJpa rj = new RatingJpa();
//		System.out.println("Priemer" + rj.avgRating(gameName));
//		System.out.println("Pocet" + rj.countRating(gameName));
		

		
		
//		
//		ScoreHibernate scoreHib = new ScoreHibernate();
//		
//		PlayerHibernate playerHib = new PlayerHibernate();
//		scoreHib.setPlayer(playerHib);
//		
//		GameHibernate gameHib =  new GameHibernate();
//		scoreHib.setGame(gameHib);
//		
//		scoreHib.setScore(1856);
		
//		String playerName = "Frantisek";
//		String gameName = "Minesweeper";
//		int rating = 1;
//		
//		PlayerHibernate player = new PlayerJpa().checkPlayer(playerName);
//		
//		GameHibernate game = new GameJpa().checkGame(gameName);
//		
//		RatingHibernate ratingHib = new RatingHibernate();
//		ratingHib.setRating(rating);
//		ratingHib.setPlayer(player);
//		ratingHib.setGame(game);
//		
//		RatingJpa rj = new RatingJpa();
//		rj.checkRating(ratingHib);
		
//		CommentsHibernate comment = new CommentsHibernate();
//		comment.setComment("Comment pre hadaj cislo");
//		comment.setPlayer(player);
//		comment.setGame(game);
//		
//		CommentJpa cj = new CommentJpa();
//		cj.addComment(comment);
		
//		ScoreHibernate scoreHib = new ScoreHibernate();
//		scoreHib.setScore(score);
//		scoreHib.setPlayer(player);
//		scoreHib.setGame(game);
//		
//		ScoreJpa sj = new ScoreJpa();
//		sj.addScore(scoreHib);
		
//		List<ScoreHibernate> pismo = sj.printTopTenScore(gameName);
//		for (int i = 0; i < pismo.size(); i++) {
//			System.out.println(pismo.get(i).getScore());
//		}
		
		
//		
//		List<ScoreHibernate> sc = sj.printTopTenScore("Stones");
//		for (int i = 0; i < sc.size(); i++) {
//			System.out.println(sc.get(i).getScore());
//		}	
		
	}
}