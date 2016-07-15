package sk.tsystems.gameStudio.entity;

public class Comment {
	private String playerId;
	private int gameId;
	private String comment;
	
	public Comment(String playerId, int gameId, String comment) {
		this.playerId = playerId;
		this.gameId = gameId;
		this.comment = comment;
	}

	public String getplayerId() {
		return playerId;
	}

	public void setplayerId(String playerId) {
		this.playerId = playerId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
