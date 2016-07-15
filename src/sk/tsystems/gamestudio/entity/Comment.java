package sk.tsystems.gamestudio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private int playerId;
	private int gameId;
	private String comment;
	
	public Comment(int playerId, int gameId, String comment) {
		this.playerId = playerId;
		this.gameId = gameId;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
