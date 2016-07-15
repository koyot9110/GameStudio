package sk.tsystems.gameStudio.service.exceptions;

public class ScoreException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ScoreException(String message) {
		super(message);
	}

	public ScoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public ScoreException(Throwable cause) {
		super(cause);
	}

}
