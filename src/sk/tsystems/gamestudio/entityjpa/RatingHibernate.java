package sk.tsystems.gamestudio.entityjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RatingHibernate {
	
	@Id
	@GeneratedValue
	private int ratingId;
	
	@ManyToOne
	private PlayerHibernate player;
	
	@ManyToOne
	private GameHibernate game;
	private int rating;
	
	public RatingHibernate() {

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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
