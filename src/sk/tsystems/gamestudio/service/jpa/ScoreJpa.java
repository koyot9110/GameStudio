package sk.tsystems.gamestudio.service.jpa;

import javax.persistence.EntityManager;

import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.entityjpa.GameHibernate;
import sk.tsystems.gamestudio.entityjpa.PlayerHibernate;
import sk.tsystems.gamestudio.entityjpa.ScoreHibernate;
import sk.tsystems.gamestudio.service.interfaces.ScoreInterface;
import sk.tsystems.jpa.JpaHelper;

public class ScoreJpa implements ScoreInterface{

	@Override
	public void addScore(Score score) {
		ScoreHibernate scoreHib = new ScoreHibernate();
		scoreHib.setScore(score.getScore());
		
		PlayerHibernate playerHib = new PlayerHibernate();
		playerHib.setPlayerId(score.getplayerId());
		scoreHib.setPlayer(playerHib);
		
		GameHibernate gameHib =  new GameHibernate();
		gameHib.setGameId(score.getGameId());
		scoreHib.setGame(gameHib);
		
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(scoreHib);
		JpaHelper.commitTransaction();
	}

	@Override
	public String printTopTenScore(String game) {
		// TODO Auto-generated method stub
		return null;
	}
}
