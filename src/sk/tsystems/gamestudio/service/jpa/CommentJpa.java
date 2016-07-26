package sk.tsystems.gamestudio.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.gamestudio.entityjpa.CommentsHibernate;
import sk.tsystems.gamestudio.service.interfaces.CommentInterface;
import sk.tsystems.jpa.JpaHelper;

public class CommentJpa implements CommentInterface{

	@Override
	public void addComment(CommentsHibernate comment) {
		
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(comment);
		JpaHelper.commitTransaction();
	}

	@Override
	public List<CommentsHibernate> printComments(String game) {

		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();

		Query query = em.createQuery("SELECT c FROM CommentsHibernate c JOIN c.game g where g.gameName=:gameName");
		query.setParameter("gameName", game);
		return query.getResultList();
	}
}
