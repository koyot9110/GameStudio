package sk.tsystems.gamestudio.service.interfaces;

import sk.tsystems.gamestudio.entity.Comment;

public interface CommentInterface {
	
	public void addComment(Comment comment);
	
	public String printComments(String game);

}
