package sk.tsystems.gamestudio.service.interfaces;

import java.util.List;
import sk.tsystems.gamestudio.entity.Comments;

public interface CommentInterface {
	
	public void addComment(Comments comment);
	
	public List<Comments> printComments(String game);

}
