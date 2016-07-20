package sk.tsystems.gamestudio.entityjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ScoreHibernate {
	
	@Id
	@GeneratedValue
	private int scoreId;
	
	@ManyToOne
	private PlayerHibernate player;
	
	@ManyToOne
	private GameHibernate game;
	private int score;
	
	public ScoreHibernate() {
		
	}

	public PlayerHibernate getPlayer() {
		return player;
	}

	public void setPlayer(PlayerHibernate player) {
		this.player = player;
	}

	public GameHibernate getGame() {
		return game;
	}

	public void setGame(GameHibernate game) {
		this.game = game;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
