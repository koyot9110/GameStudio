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
		
		
//		Comments comment = new Comments(1, 1, "Mozno to pojde, ale pravdepodobne asi nie");
//		Comments cj = new Comments("duri", "asddddddddddddddddddddddasssssssssssssssssss");
//		cj.addComment(comment);
		
//		CommentImpl comImpl = new CommentImpl();
//		List<Comments> list = comImpl.printComments("Stones");
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getPlayerName() + ": " + list.get(i).getComment());
//		}
		
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
//		String playerName = "Duri";
//		String gameName = "Stones";
//		int score = 1562;
//		
//		PlayerHibernate player = new PlayerJpa().checkPlayer(playerName);
//		
//		GameHibernate game = new GameJpa().checkGame(gameName);
//		
//		ScoreHibernate scoreHib = new ScoreHibernate();
//		scoreHib.setScore(score);
//		scoreHib.setPlayer(player);
//		scoreHib.setGame(game);
//		
//		ScoreJpa sj = new ScoreJpa();
//		sj.addScore(scoreHib);
//		
//		List<ScoreHibernate> pismo = sj.printTopTenScore("Stones");
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