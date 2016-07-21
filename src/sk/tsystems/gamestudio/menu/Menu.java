package sk.tsystems.gamestudio.menu;

import java.util.List;

import sk.tsystems.gamestudio.entity.Comments;
import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.entityjpa.CommentsHibernate;
import sk.tsystems.gamestudio.service.impl.CommentImpl;
import sk.tsystems.gamestudio.service.jpa.CommentJpa;
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
		
		
//		Score score = new Score(1, 1, 1500);
//		ScoreJpa sj = new ScoreJpa();
//		sj.addScore(score);
		
		
		
		
		
	}
}