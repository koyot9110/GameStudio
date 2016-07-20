package sk.tsystems.gamestudio.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import sk.tsystems.gamestudio.entity.Comment;
import sk.tsystems.gamestudio.service.exceptions.ServiceException;
import sk.tsystems.gamestudio.service.interfaces.CommentInterface;

public class CommentImpl implements CommentInterface {

	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";

	public static final String INSERT_COMMENT = "INSERT INTO comments (COMMENTID, PLAYERID, GAMEID, COMMENTS) VALUES (comment_seq.nextval, ?, ?, ?)";

	public static final String SELECT_COMMENTS = "SELECT p.PLAYERNAME, g.GAMENAME, c.comments FROM player p JOIN comments c ON p.PLAYERID = c.PLAYERID JOIN game g ON c.GAMEID = g.GAMEID WHERE c.COMMENTS IS NOT NULL";

	@Override
	public void addComment(Comment comment) {

		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(INSERT_COMMENT);
			stmt.setInt(1, comment.getplayerId());
			stmt.setInt(2, comment.getGameId());
			stmt.setString(3, comment.getComment());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error: Wrong insert comment");
		}
	}

	@Override
	public String printComments(String game) {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(SELECT_COMMENTS);
			StringBuilder builder = new StringBuilder();
			while (res.next()) {
				if (res.getString(2).equals(game)) {
					builder.append("PLAYER: " + res.getString(1) + ", GAME: " + res.getString(2)
							+ ", COMMENT: " + res.getString(3) + "\n");
				}
			}
			return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error: Wrong print comments");
		}
	}
}
