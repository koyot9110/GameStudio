package sk.tsystems.gamestudio.menu;

import java.util.List;

import sk.tsystems.gamestudio.entity.Comments;
import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.service.impl.CommentImpl;
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
		CommentImpl cj = new CommentImpl();
//		cj.addComment(comment);
		
		List<String> pismo = cj.printComments("Stones");
		
		for (String s : pismo) {
			System.out.println(s);
		}
		System.out.println(cj.printComments("Stones"));
		
		
//		Score score = new Score(1, 1, 1500);
//		ScoreJpa sj = new ScoreJpa();
//		sj.addScore(score);
		
		
		
		
		
	}
}
