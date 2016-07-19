package sk.tsystems.gamestudio.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sk.tsystems.gamestudio.service.exceptions.ScoreException;

public class GameUtil {
private int gameId;
	
	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";
	
	public static final String SELECT_GAME = "SELECT gameid FROM game WHERE gamename like ? ";

	public static final String INSERT_GAME = "INSERT INTO game (GAMEID,GAMENAME) VALUES (GAME_SEQ.NEXTVAL,?)";
	
	public int checkGame(String GameName) {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(SELECT_GAME);
			stmt.setString(1, GameName);
			ResultSet res = stmt.executeQuery();
			
			while (res.next()) {
				gameId = res.getInt(1);
			}
			
			if (gameId == 0) {
				PreparedStatement stmt1 = con.prepareStatement(INSERT_GAME);
				stmt1.setString(1, GameName);
				stmt1.executeUpdate();
				checkGame(GameName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("Error: Wrong select game id");
		}
		return gameId;
	}
}
