package sk.tsystems.gamestudio.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Rating> avgRating(String game) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Rating> countRating(String game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating checkRating(Rating rating, String playerName, String gameName) {
		// TODO Auto-generated method stub
		return null;
	}
}
