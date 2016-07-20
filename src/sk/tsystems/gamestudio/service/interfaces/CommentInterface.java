package sk.tsystems.gamestudio.service.interfaces;

import sk.tsystems.gamestudio.entity.Comments;

public interface CommentInterface {
	
	public void addComment(Comments comment);
	
	public String printComments(String game);

}
