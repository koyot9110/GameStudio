package sk.tsystems.gamestudio.service.interfaces;

import java.util.List;

import sk.tsystems.gamestudio.entityjpa.ScoreHibernate;

public interface ScoreInterface {
	
	public void addScore(ScoreHibernate score);
	
	public List<ScoreHibernate> printTopTenScore(String game);

}
