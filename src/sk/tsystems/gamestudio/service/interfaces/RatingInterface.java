package sk.tsystems.gamestudio.service.interfaces;

import sk.tsystems.gamestudio.entity.Rating;

public interface RatingInterface {

	public void addRating(Rating rating);
	
	public String avgRating(String game);
	
	public Rating checkRating(Rating rating, String playerName, String gameName);
	
	public void deleteRating(Rating rating);
	
}
