package sk.tsystems.gamestudio.entityjpa;

public class GameHibernate {

	private int gameId;
	private String gameName;
	
	public GameHibernate() {

	}
	
	public int getGameId() {
		return gameId;
	}
	
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	public String getGameName() {
		return gameName;
	}
	
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
}
