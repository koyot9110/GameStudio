package sk.tsystems.gamestudio.entity;

public class Rating {

	private int playerId;
	private int gameId;
	private int rating;
	
	public Rating(int playerId, int gameId, int rating) {
		this.playerId = playerId;
		this.gameId = gameId;
		this.rating = rating;
	}
	
	public Rating(){
		
	}

	public int getplayerId() {
		return playerId;
	}

	public void setplayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
