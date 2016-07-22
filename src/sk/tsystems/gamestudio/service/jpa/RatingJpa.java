package sk.tsystems.gamestudio.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.gamestudio.entity.Rating;
import sk.tsystems.gamestudio.entityjpa.GameHibernate;
import sk.tsystems.gamestudio.entityjpa.PlayerHibernate;
import sk.tsystems.gamestudio.entityjpa.RatingHibernate;
import sk.tsystems.gamestudio.service.interfaces.RatingInterface;
import sk.tsystems.jpa.JpaHelper;

public class RatingJpa implements RatingInterface{

	@Override
	public void addRating(Rating rating) {
		
		RatingHibernate ratingHib =  new RatingHibernate();
		ratingHib.setRating(rating.getRating());
		
		PlayerHibernate playerHib = new PlayerHibernate();
		playerHib.setPlayerId(rating.getplayerId());
		ratingHib.setPlayer(playerHib);
		
		GameHibernate gameHib =  new GameHibernate();
		gameHib.setGameId(rating.getGameId());
		ratingHib.setGame(gameHib);
		
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(ratingHib);
		JpaHelper.commitTransaction();
		
	}
	
	@Override
	public void deleteRating(Rating rating) {
		
		RatingHibernate ratingHib =  new RatingHibernate();
		ratingHib.setRating(rating.getRating());
		
		PlayerHibernate playerHib = new PlayerHibernate();
		playerHib.setPlayerId(rating.getplayerId());
		ratingHib.setPlayer(playerHib);
		
		GameHibernate gameHib =  new GameHibernate();
		gameHib.setGameId(rating.getGameId());
		ratingHib.setGame(gameHib);
		
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();
		
		JpaHelper.beginTransaction();
		em.remove(ratingHib);
		JpaHelper.commitTransaction();
	}

	@Override
	public List<Rating> avgRating(String game) {
		
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();

		Query query = em.createQuery("SELECT avg(r.transfusionUnits) FROM RatingHibernate r JOIN r.game g where g.gameName=:gameName");
		query.setParameter("gameName", game);
		return query.getResultList();
	}
	
	@Override
	public List<Rating> countRating(String game) {
		
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();

		Query query = em.createQuery("SELECT sum(r.transfusionUnits) FROM RatingHibernate r JOIN r.game g where g.gameName=:gameName");
		query.setParameter("gameName", game);
		return query.getResultList();
	}

	@Override
	public Rating checkRating(Rating rating, String playerName, String gameName) {
		
		RatingHibernate ratingHib = new RatingHibernate();
		ratingHib.setRating(rating.getRating());
		
		PlayerHibernate playerHib = new PlayerHibernate();
		playerHib.setPlayerName(playerName);
		ratingHib.setPlayer(playerHib);
		
		GameHibernate gameHib = new GameHibernate();
		gameHib.setGameName(gameName);
		ratingHib.setGame(gameHib);
		
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		if (false) {
			addRating(rating);
		} else {
			deleteRating(rating);
			addRating(rating);
		}
		JpaHelper.commitTransaction();
		
		return rating;
	}
}
