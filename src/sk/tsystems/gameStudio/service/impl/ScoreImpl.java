package sk.tsystems.gameStudio.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import sk.tsystems.gameStudio.entity.Score;
import sk.tsystems.gameStudio.service.exceptions.ScoreException;
import sk.tsystems.gameStudio.service.interfaces.Scores;

public class ScoreImpl implements Scores{
	
	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";

	public static final String INSERT_SCORE = "INSERT INTO score (SCOREID, PLAYERID, GAMEID, SCORE) VALUES (score_seq.nextval, ?, ?, ?)";

	@Override
	public void addScore(Score score) {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(INSERT_SCORE);
			stmt.setInt(1, score.getplayerId());
			stmt.setInt(2, score.getGameId());
			stmt.setInt(3, score.getScore());
			stmt.executeUpdate();
			System.out.println("ta sos kere mange");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("Error: Wrong insert score");
		}
		
	}

	@Override
	public void printScore() {
		// TODO Auto-generated method stub
	}
}
