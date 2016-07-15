package sk.tsystems.gameStudio.service.impl;

import sk.tsystems.gameStudio.entity.Comment;
import sk.tsystems.gameStudio.service.interfaces.Comments;

public class CommentImpl implements Comments{
	
	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";

	public static final String INSERT_SCORE = "INSERT INTO score (SCOREID, PLAYERID, GAMEID, SCORE) VALUES (seq_score.nextval, ?, ?, ?)";

	public static final String SELECT_SCORE = "SELECT name, score FROM score";
	
	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void printComments() {
		// TODO Auto-generated method stub
	}
}