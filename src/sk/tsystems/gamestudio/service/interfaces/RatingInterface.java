package sk.tsystems.gamestudio.service.interfaces;

import java.util.List;

import sk.tsystems.gamestudio.entity.Rating;

public interface RatingInterface {

	public void addRating(Rating rating);
	
	public void deleteRating(Rating rating);
	
	public List<Rating> avgRating(String game);
	
	public List<Rating> countRating(String game);
	
	public Rating checkRating(Rating rating, String playerName, String gameName);
	
}
