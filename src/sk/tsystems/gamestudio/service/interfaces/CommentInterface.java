package sk.tsystems.gamestudio.service.interfaces;

import java.util.List;
import sk.tsystems.gamestudio.entityjpa.CommentsHibernate;

public interface CommentInterface {
	
	public void addComment(CommentsHibernate comment);
	
	public List<CommentsHibernate> printComments(String game);

}
