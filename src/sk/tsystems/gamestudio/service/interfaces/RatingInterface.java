package sk.tsystems.gamestudio.service.interfaces;

import sk.tsystems.gamestudio.entity.Rating;

public interface RatingInterface {

	public void addRating(Rating rating);
	
	public void avgRating(String game);
	
	public void countRating(String game);
	
}
