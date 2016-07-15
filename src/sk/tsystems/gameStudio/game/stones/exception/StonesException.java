package sk.tsystems.gameStudio.game.stones.exception;

public class StonesException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StonesException(String message, Throwable cause) {
		super(message, cause);
	}

	public StonesException(String message) {
		super(message);
	}	
}
