package sk.tsystems.gamestudio.menu;

import sk.tsystems.gamestudio.entity.Comments;
import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.service.jpa.CommentJpa;
import sk.tsystems.gamestudio.service.jpa.ScoreJpa;

public class Menu {

	public static void main(String[] args) {

//		MenuUI console = new MenuUI();
//		
//		do {
//			console.printMenu();
//			console.runGames();
//		} while (true);
		
		
//		Comments comment = new Comments(1, 1, "Mozno to pojde, ale pravdepodobne asi nie");
//		CommentJpa cj = new CommentJpa();
//		cj.addComment(comment);
		
		
		Score score = new Score(1, 1, 1500);
		ScoreJpa sj = new ScoreJpa();
		sj.addScore(score);
		
		
		
	}
}
