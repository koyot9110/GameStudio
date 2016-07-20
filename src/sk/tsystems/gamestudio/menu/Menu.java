package sk.tsystems.gamestudio.menu;

import sk.tsystems.gamestudio.entity.Comments;
import sk.tsystems.gamestudio.entity.Rating;
import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.service.impl.CommentImpl;
import sk.tsystems.gamestudio.service.impl.RatingImpl;
import sk.tsystems.gamestudio.service.impl.ScoreImpl;
import sk.tsystems.gamestudio.service.jpa.CommentJpa;

public class Menu {

	public static void main(String[] args) {

//		MenuUI console = new MenuUI();
//		
//		do {
//			console.printMenu();
//			console.runGames();
//		} while (true);
		
//		Score df = new Score(22, 2, 15);
//		
//		ScoreImpl sc = new ScoreImpl();
//		System.out.println(sc.printTopTenScore("Minesweeper"));
		
		Comments cm = new Comments(1, 1, "tralala");
		
		CommentJpa cj = new CommentJpa();
		cj.addComment(cm);
		
//		Rating rt = new Rating(51, 1, 4);
//		RatingImpl ri = new RatingImpl();
//		ri.checkRating(rt);
//		System.out.println(ri.avgRating("GuessNumber"));
	}
}
