package sk.tsystems.gamestudio.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.gamestudio.entityjpa.RatingHibernate;
import sk.tsystems.gamestudio.service.interfaces.RatingInterface;
import sk.tsystems.jpa.JpaHelper;

public class RatingJpa implements RatingInterface {

	@Override
	public void addRating(RatingHibernate rating) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(rating);
		JpaHelper.commitTransaction();
	}

	private void deleteRating(RatingHibernate rating) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.remove(rating);
		JpaHelper.commitTransaction();
	}

	@Override
	public double avgRating(String gameName) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();

		double rate = (double) em.createQuery("SELECT avg(r.rating) FROM RatingHibernate r JOIN r.game g where g.gameName=:gameName").setParameter("gameName", gameName).getSingleResult();
		return rate;
	}

	@Override
	public long countRating(String gameName) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();

		long rate = (long) em.createQuery("SELECT count(r.rating) FROM RatingHibernate r JOIN r.game g where g.gameName=:gameName").setParameter("gameName", gameName).getSingleResult();
		return rate;
	}

	@Override
	public RatingHibernate checkRating(RatingHibernate rating, String playerName, String gameName) {
		PlayerJpa player = new PlayerJpa();
		GameJpa game = new GameJpa();
		
		if (player.checkPlayer(playerName).equals(playerName) && game.checkGame(gameName).equals(gameName)) {
			deleteRating(rating);
			addRating(rating);
		} else {
			addRating(rating);
		}
		return rating;
	}
}
