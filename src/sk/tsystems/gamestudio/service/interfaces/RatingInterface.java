package sk.tsystems.gamestudio.service.interfaces;

import sk.tsystems.gamestudio.entityjpa.RatingHibernate;

public interface RatingInterface {
	
	public double avgRating(String game);
	
	public long countRating(String game);
	
	public void checkRating(RatingHibernate rating);
	
}
