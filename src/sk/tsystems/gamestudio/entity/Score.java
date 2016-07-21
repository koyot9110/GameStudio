package sk.tsystems.gamestudio.entity;

public class Score {

	private int playerId;
	private int gameId;
	private String playerName;
	private int score;
	
	public Score(int playerId, int gameId, int score) {
		this.playerId = playerId;
		this.gameId = gameId;
		this.score = score;
	}

	public Score(String playerName, int score) {
		super();
		this.playerName = playerName;
		this.score = score;
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
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	
}
