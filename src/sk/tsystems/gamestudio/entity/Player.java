package sk.tsystems.gamestudio.entity;

public class Player {
	
	private int playerId;
	private String playerName;
	
	public Player() {
		
	}
	
	public int getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}
