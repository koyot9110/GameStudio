package sk.tsystems.gamestudio.service.jpa;

import javax.persistence.EntityManager;

import sk.tsystems.gamestudio.entity.Comments;
import sk.tsystems.gamestudio.entityjpa.CommentsHibernate;
import sk.tsystems.gamestudio.entityjpa.GameHibernate;
import sk.tsystems.gamestudio.entityjpa.PlayerHibernate;
import sk.tsystems.gamestudio.service.interfaces.CommentInterface;
import sk.tsystems.jpa.JpaHelper;

public class CommentJpa implements CommentInterface{

	@Override
	public void addComment(Comments comment) {
		CommentsHibernate comHib = new CommentsHibernate();
		comHib.setComment(comment.getComment());
		
		PlayerHibernate playerHib = new PlayerHibernate();
		playerHib.setPlayerId(comment.getplayerId());
		comHib.setPlayer(playerHib);
		
		GameHibernate gameHib =  new GameHibernate();
		gameHib.setGameId(comment.getGameId());
		comHib.setGame(gameHib);
		
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(comHib);
		JpaHelper.commitTransaction();
	}

	@Override
	public String printComments(String game) {
		// TODO Auto-generated method stub
		return null;
	}
}
