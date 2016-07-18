package sk.tsystems.gamestudio.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.service.exceptions.ScoreException;
import sk.tsystems.gamestudio.service.interfaces.ScoreInterface;

public class ScoreImpl implements ScoreInterface {

	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";

	public static final String INSERT_SCORE = "INSERT INTO score (SCOREID, PLAYERID, GAMEID, SCORE) VALUES (score_seq.nextval, ?, ?, ?)";

	public static final String SELECT_SCORE = "SELECT * FROM (SELECT p.PLAYERNAME, g.GAMENAME, s.score FROM player p JOIN score s ON p.PLAYERID = s.PLAYERID JOIN game g ON s.GAMEID = g.GAMEID ORDER BY s.score) WHERE ROWNUM <=10";

	public static final String SELECT_PLAYER = "SELECT playerid FROM PLAYER WHERE PLAYERNAME like ? ";

	public static final String INSERT_PLAYER = "INSERT INTO PLAYER (PLAYERID,PLAYERNAME) VALUES (PLAYER_SEQ.NEXTVAL,?)";

	@Override
	public void addScore(Score score) {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(INSERT_SCORE);
			stmt.setInt(1, score.getplayerId());
			stmt.setInt(2, score.getGameId());
			stmt.setInt(3, score.getScore());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("Error: Wrong insert score");
		}
	}

	@Override
	public String printTopTenScore(String game) {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(SELECT_SCORE);
			StringBuilder builder = new StringBuilder();
			int index = 0;
			while (res.next()) {
				if (res.getString(2).equals(game)) {
					index++;
					builder.append(index + ". " + "PLAYER: " + res.getString(1)
							+ ", GAME: " + res.getString(2) + ", SCORE: "
							+ res.getInt(3) + "sec.\n");
				}
			}
			return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("Error: Wrong print score");
		}
	}

	public int checkName(String name) {
		int playerID = 0;
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(SELECT_PLAYER);
			stmt.setString(1, name);
			ResultSet res = stmt.executeQuery();
			
			while (res.next()) {
				playerID = res.getInt(1);
			}
			
			if (playerID == 0) {
				PreparedStatement stmt1 = con.prepareStatement(INSERT_PLAYER);
				stmt1.setString(1, name);
				stmt1.executeUpdate();
				checkName(name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScoreException("Error: Wrong select id");
		}
		return playerID;
	}
}
