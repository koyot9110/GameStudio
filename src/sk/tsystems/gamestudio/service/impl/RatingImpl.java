package sk.tsystems.gamestudio.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import sk.tsystems.gamestudio.entity.Rating;
import sk.tsystems.gamestudio.service.exceptions.ServiceException;
import sk.tsystems.gamestudio.service.interfaces.RatingInterface;

public class RatingImpl implements RatingInterface {

	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";

	public static final String INSERT_RATING = "INSERT INTO rating (PLAYERID, GAMEID, RATING) VALUES (?, ?, ?)";

	public static final String SELECT_AVG_RATING = "SELECT g.gamename, AVG(r.rating) AS avg, COUNT(r.rating) AS count FROM rating r JOIN game g ON r.GAMEID = g.GAMEID GROUP BY g.GAMENAME";

	public static final String SELECT_RATING = "SELECT p.PLAYERNAME, g.GAMENAME, r.rating FROM rating r JOIN game g ON r.GAMEID = g.GAMEID JOIN player p ON r.PLAYERID = p.PLAYERID WHERE p.PLAYERNAME like ? AND g.GAMENAME like ?";
	
	public static final String DELETE_RATING = "delete from rating where playerid like ? AND gameid like ?";
	
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
			throw new ServiceException("Error: Wrong insert rating");
		}
	}
	
	@Override
	public void deleteRating(Rating rating){
		try{
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		PreparedStatement stmt = con.prepareStatement(DELETE_RATING);
		stmt.setInt(1, rating.getplayerId());
		stmt.setInt(2, rating.getGameId());
		stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error: Wrong delete rating");
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
			throw new ServiceException("Error: Wrong avg rating");
		}
	}
	
	@Override
	public Rating checkRating(Rating rating, String playerName, String gameName) {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(SELECT_RATING);
			stmt.setString(1, playerName);
			stmt.setString(2, gameName);
			ResultSet res = stmt.executeQuery();
			
			if (!res.next()) {
				addRating(rating);
			} else {
				deleteRating(rating);
				addRating(rating);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error: Wrong check rating");
		}
		return rating;
	}
}
