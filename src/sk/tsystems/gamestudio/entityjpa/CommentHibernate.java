package sk.tsystems.gamestudio.entityjpa;

public class CommentHibernate {
	
	private int commentId;
	private int playerId;
	private int gameId;
	private String comment;
	
	public CommentHibernate(int playerId, int gameId, String comment) {
		this.playerId = playerId;
		this.gameId = gameId;
		this.comment = comment;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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
