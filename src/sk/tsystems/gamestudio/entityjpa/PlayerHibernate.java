package sk.tsystems.gamestudio.entityjpa;

public class PlayerHibernate {
	
	private int playerId;
	private String playerName;
	
	public PlayerHibernate(int playerId, String playerName) {
		this.playerId = playerId;
		this.playerName = playerName;
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
