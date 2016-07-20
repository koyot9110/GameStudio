package sk.tsystems.gamestudio.entityjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CommentsHibernate {
	
	@Id
	@GeneratedValue
	private int commentId;
	
	@ManyToOne
	private PlayerHibernate player;
	
	@ManyToOne
	private GameHibernate game;
	private String comment;
	
	public CommentsHibernate(){
		
	}
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
