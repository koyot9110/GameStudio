package sk.tsystems.gamestudio.service.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.gamestudio.entityjpa.GameHibernate;
import sk.tsystems.jpa.JpaHelper;

public class GameJpa {
	
	private void insertGame(GameHibernate game) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(game);
		JpaHelper.commitTransaction();
	}

	private GameHibernate getGame(int gameId) {
		EntityManager em = JpaHelper.getEntityManager();
		return em.find(GameHibernate.class, gameId);
	}

	private int getGameId(String gameName) {
		int gameId = 0;
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select gameId from GameHibernate g where g.gameName=:gameName");
		query.setParameter("gameName", gameName);
		if (query.getResultList().isEmpty()) {
			gameId = 0;
		} else {
			gameId = (int) query.getResultList().get(0);
		}
		return gameId;
	}

	public GameHibernate checkGame(String gameName) {
		int gameId = getGameId(gameName);
		if (gameId != 0) {
			return getGame(gameId);
		} else {
			GameHibernate gameHib = new GameHibernate(gameName);
			insertGame(gameHib);
			return gameHib;
		}
	}
}
