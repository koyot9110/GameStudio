package sk.tsystems.gamestudio.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sk.tsystems.gamestudio.service.exceptions.ScoreException;

public class PlayerUtil {
	
	private int playerId;
	
	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";
	
	public static final String SELECT_PLAYER = "SELECT playerid FROM PLAYER WHERE PLAYERNAME like ? ";

	public static final String INSERT_PLAYER = "INSERT INTO PLAYER (PLAYERID,PLAYERNAME) VALUES (PLAYER_SEQ.NEXTVAL,?)";
	
	public int checkName(String PlayerName) {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(SELECT_PLAYER);
			stmt.setString(1, PlayerName);
			ResultSet res = stmt.executeQuery();
			
			while (res.next()) {
				playerId = res.getInt(1);
			}
			
			if (playerId == 0) {
				PreparedStatement stmt1 = con.prepareStatement(INSERT_PLAYER);
				stmt1.setString(1, PlayerName);
				stmt1.executeUpdate();
				checkName(PlayerName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("Error: Wrong select player id");
		}
		return playerId;
	}
}
