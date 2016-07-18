package sk.tsystems.gamestudio.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import sk.tsystems.gamestudio.entity.Rating;
import sk.tsystems.gamestudio.service.exceptions.ScoreException;
import sk.tsystems.gamestudio.service.interfaces.RatingInterface;

public class RatingImpl implements RatingInterface {

	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";

	public static final String INSERT_RATING = "INSERT INTO rating (PLAYERID, GAMEID, RATING) VALUES (?, ?, ?)";

	public static final String SELECT_AVG_RATING = "SELECT g.gamename, AVG(r.rating) AS avg, COUNT(r.rating) AS count FROM rating r JOIN game g ON r.GAMEID = g.GAMEID GROUP BY g.GAMENAME";

	@Override
	public void addRating(Rating rating) {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(INSERT_RATING);
			stmt.setInt(1, rating.getplayerId());
			stmt.setInt(2, rating.getGameId());
			stmt.setInt(3, rating.getRating());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("Error: Wrong insert rating");
		}

	}

	@Override
	public String avgRating(String game) {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(SELECT_AVG_RATING);
			StringBuilder builder = new StringBuilder();
			while (res.next()) {
				if (res.getString(1).equals(game)) {
					builder.append("GAME: " + res.getString(1) + ", AVERAGE RATE: " + res.getInt(2)
							+ "*, COUNT RATE: " + res.getInt(3));
				}
			}
			return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("Error: Wrong avg rating");
		}
	}
}
