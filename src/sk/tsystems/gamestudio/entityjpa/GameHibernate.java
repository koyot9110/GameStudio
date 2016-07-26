package sk.tsystems.gamestudio.entityjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GameHibernate {

	@Id
	@GeneratedValue
	private int gameId;
	private String gameName;
	
	public GameHibernate(String gameName) {
		this.gameName = gameName;
	}

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
