package sk.tsystems.gameStudio.entity;

public class Score {
	private int playerId;
	private int gameId;
	private int score;
	
	public Score(int playerId, int gameId, int score) {
		this.playerId = playerId;
		this.gameId = gameId;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	
}
