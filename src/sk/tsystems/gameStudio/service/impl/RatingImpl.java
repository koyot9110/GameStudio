package sk.tsystems.gameStudio.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import sk.tsystems.gameStudio.entity.Rating;
import sk.tsystems.gameStudio.service.exceptions.ScoreException;
import sk.tsystems.gameStudio.service.interfaces.RatingInterface;

public class RatingImpl implements RatingInterface{
	
	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";

	public static final String INSERT_SCORE = "INSERT INTO score (SCOREID, PLAYERID, GAMEID, SCORE) VALUES (seq_score.nextval, ?, ?, ?)";

	public static final String SELECT_SCORE = "SELECT name, score FROM score";

	@Override
	public void addRating(Rating rating) {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(INSERT_SCORE);
			stmt.setInt(1, rating.getplayerId());
			stmt.setInt(2, rating.getGameId());
			stmt.setInt(3, rating.getRating());
			stmt.executeUpdate();
			System.out.println("ta sos kere mange");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("Error: Wrong insert score");
		}
		
	}

	@Override
	public void avgRating(String game) {
		// TODO Auto-generated method stub
	}

	@Override
	public void countRating(String game) {
		// TODO Auto-generated method stub
	}
}
