package sk.tsystems.gamestudio.service.interfaces;

import sk.tsystems.gamestudio.entity.Score;

public interface ScoreInterface {
	
	public void addScore(Score score);
	
	public String printTopTenScore(String game);

}
