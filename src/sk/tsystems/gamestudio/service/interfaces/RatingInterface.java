package sk.tsystems.gamestudio.service.interfaces;

import java.util.List;

import sk.tsystems.gamestudio.entityjpa.RatingHibernate;

public interface RatingInterface {

	public void addRating(RatingHibernate rating);
	
	public double avgRating(String game);
	
	public long countRating(String game);
	
	public RatingHibernate checkRating(RatingHibernate rating, String playerName, String gameName);
	
}
