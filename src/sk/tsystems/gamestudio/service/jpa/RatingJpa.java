package sk.tsystems.gamestudio.service.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.gamestudio.entityjpa.RatingHibernate;
import sk.tsystems.gamestudio.service.interfaces.RatingInterface;
import sk.tsystems.jpa.JpaHelper;

public class RatingJpa implements RatingInterface {

	@Override
	public double avgRating(String gameName) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();

		double rate = (double) em
				.createQuery("SELECT avg(r.rating) FROM RatingHibernate r JOIN r.game g where g.gameName=:gameName")
				.setParameter("gameName", gameName).getSingleResult();
		return rate;
	}

	@Override
	public long countRating(String gameName) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();

		long rate = (long) em
				.createQuery("SELECT count(r.rating) FROM RatingHibernate r JOIN r.game g where g.gameName=:gameName")
				.setParameter("gameName", gameName).getSingleResult();
		return rate;
	}

	@Override
	public void checkRating(RatingHibernate rating) {
		String playerName = rating.getPlayer().getPlayerName();
		String gameName = rating.getGame().getGameName();
		int id = getIdRaiting(playerName, gameName);
		if (id == 0) {
			addRating(rating);
		} else {
			deleteRating(id);
			addRating(rating);
		}
	}

	private void addRating(RatingHibernate rating) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(rating);
		JpaHelper.commitTransaction();
	}

	private void deleteRating(int id) {
		RatingHibernate rating = new RatingHibernate();
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		rating = em.find(RatingHibernate.class, id);
		em.remove(rating);
		JpaHelper.commitTransaction();
	}

	private int getIdRaiting(String playerName, String gameName) {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT ratingId FROM RatingHibernate r WHERE r.player=:player AND r.game=:game");
		query.setParameter("player", new PlayerJpa().checkPlayer(playerName));
		query.setParameter("game", new GameJpa().checkGame(gameName));
		if (query.getResultList().isEmpty()) {
			return 0;
		} else {
			return (int) query.getResultList().get(0);
		}
	}
}
