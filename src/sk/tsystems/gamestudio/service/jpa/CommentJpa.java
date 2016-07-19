package sk.tsystems.gamestudio.service.jpa;

import javax.persistence.EntityManager;

import sk.ness.jpa.JpaHelper;
import sk.tsystems.gamestudio.entity.Comment;
import sk.tsystems.gamestudio.service.interfaces.CommentInterface;

public class CommentJpa implements CommentInterface{

	@Override
	public void addComment(Comment comment) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(comment);
		JpaHelper.commitTransaction();
	}

	@Override
	public String printComments(String game) {
		// TODO Auto-generated method stub
		return null;
	}

}