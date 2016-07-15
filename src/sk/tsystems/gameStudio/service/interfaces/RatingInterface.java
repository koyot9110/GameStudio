package sk.tsystems.gameStudio.service.interfaces;

import sk.tsystems.gameStudio.entity.Rating;

public interface RatingInterface {

	public void addRating(Rating rating);
	
	public void avgRating(String game);
	
	public void countRating(String game);
	
}
