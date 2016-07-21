package sk.tsystems.gamestudio.entity;

public class Comments {
	
	private int playerId;
	private int gameId;
	private String playerName;
	private String comment;
	
	public Comments(int playerId, int gameId, String comment) {
		this.playerId = playerId;
		this.gameId = gameId;
		this.comment = comment;
	}

	public Comments(String playerName, String comment) {
		this.playerName = playerName;
		this.comment = comment;
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

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
