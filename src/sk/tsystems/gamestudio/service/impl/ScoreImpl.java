package sk.tsystems.gamestudio.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sk.tsystems.gamestudio.entity.Score;
import sk.tsystems.gamestudio.service.exceptions.ServiceException;
import sk.tsystems.gamestudio.service.interfaces.ScoreInterface;

public class ScoreImpl implements ScoreInterface {

	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "123456789";

	public static final String INSERT_SCORE = "INSERT INTO score (SCOREID, PLAYERID, GAMEID, SCORE) VALUES (score_seq.nextval, ?, ?, ?)";

	public static final String SELECT_SCORE = "SELECT * FROM (SELECT p.PLAYERNAME, g.GAMENAME, s.score FROM player p JOIN score s ON p.PLAYERID = s.PLAYERID JOIN game g ON s.GAMEID = g.GAMEID ORDER BY s.score DESC) WHERE ROWNUM <=10  AND GAMENAME like ?";

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
			throw new ServiceException("Error: Wrong insert score");
		}
	}

	@Override
	public List<Score> printTopTenScore(String game) {
		List<Score> list = new ArrayList<Score>();
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = con.prepareStatement(SELECT_SCORE);
			stmt.setString(1, game);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				if (res.getString(2).equals(game)) {
					list.add(new Score(res.getString(1), res.getInt(3)));
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error: Wrong print score");
		}
	}
}
