package sk.tsystems.gamestudio.game.minesweeper.exception;

/**
 * Wrong format exception.
 */
public class WrongFormatException extends Exception {
	private static final long serialVersionUID = 1L;
	public WrongFormatException(String message, Throwable cause) {
		super(message, cause);
	}
	 /**
     * Constructor.
     * @param message message
     */
    public WrongFormatException(String message) {
        super(message);
    }

	
}