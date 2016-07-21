package sk.tsystems.gamestudio.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	public List<Score> printTopTenScore(String game) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();

		Query query = em.createQuery("SELECT s FROM ScoreHibernate c JOIN c.game g where g.gameName=:gameName");
		query.setParameter("gameName", game);
		return query.getResultList();
	}
}
