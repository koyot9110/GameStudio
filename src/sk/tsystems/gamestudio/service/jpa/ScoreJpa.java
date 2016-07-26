package sk.tsystems.gamestudio.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.gamestudio.entityjpa.ScoreHibernate;
import sk.tsystems.gamestudio.service.interfaces.ScoreInterface;
import sk.tsystems.jpa.JpaHelper;

public class ScoreJpa implements ScoreInterface{

	@Override
	public void addScore(ScoreHibernate score) {
		
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(score);
		JpaHelper.commitTransaction();
	}
	
	@Override
	public List<ScoreHibernate> printTopTenScore(String game) {
		
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();

		Query query = em.createQuery("SELECT s FROM ScoreHibernate s JOIN s.game g WHERE g.gameName=:gameName ORDER BY s.score DESC");
		query.setParameter("gameName", game);
		return query.getResultList();
	}
}
//public static final String SELECT_SCORE = "SELECT * FROM (SELECT p.PLAYERNAME, g.GAMENAME, s.score FROM player p JOIN score s ON p.PLAYERID = s.PLAYERID JOIN game g ON s.GAMEID = g.GAMEID ORDER BY s.score DESC) WHERE ROWNUM <=10  AND GAMENAME like ?";
