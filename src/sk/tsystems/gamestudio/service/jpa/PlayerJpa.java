package sk.tsystems.gamestudio.service.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.gamestudio.entityjpa.PlayerHibernate;
import sk.tsystems.jpa.JpaHelper;

public class PlayerJpa {

	private void insertPlayer(PlayerHibernate player) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(player);
		JpaHelper.commitTransaction();
	}

	private PlayerHibernate getPlayer(int playerId) {
		EntityManager em = JpaHelper.getEntityManager();
		return em.find(PlayerHibernate.class, playerId);
	}

	private int getPlayerId(String playerName) {
		int playerId = 0;
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select playerId from PlayerHibernate p where p.playerName=:playerName");
		query.setParameter("playerName", playerName);
		if (query.getResultList().isEmpty()) {
			playerId = 0;
		} else {
			playerId = (int) query.getResultList().get(0);
		}
		return playerId;
	}

	public PlayerHibernate checkPlayer(String playerName) {
		int playerId = getPlayerId(playerName);
		if (playerId != 0) {
			return getPlayer(playerId);
		} else {
			PlayerHibernate playerHib = new PlayerHibernate(playerName);
			insertPlayer(playerHib);
			return playerHib;
		}
	}
}
