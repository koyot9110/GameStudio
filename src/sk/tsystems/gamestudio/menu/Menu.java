package sk.tsystems.gamestudio.menu;

import sk.tsystems.gamestudio.entity.Comment;
import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.service.impl.ScoreImpl;
import sk.tsystems.gamestudio.service.jpa.CommentJpa;

public class Menu {

	public static void main(String[] args) {

//		Game console = new Game();
//		
//		do {
//			console.printMenu();
//			console.runGames();
//		} while (true);
		
//		Score df = new Score(22, 2, 15);
//		
//		ScoreImpl sc = new ScoreImpl();
//		sc.addScore(df);
		
		Comment cm = new Comment(22, 2, "Tadeas chce ist domov");
		
		CommentJpa cj = new CommentJpa();
		cj.addComment(cm);
		
	}
}
