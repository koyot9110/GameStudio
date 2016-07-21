package sk.tsystems.gamestudio.service.interfaces;

import java.util.List;

import sk.tsystems.gamestudio.entity.Score;

public interface ScoreInterface {
	
	public void addScore(Score score);
	
	public List<Score> printTopTenScore(String game);

}
