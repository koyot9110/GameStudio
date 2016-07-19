package sk.tsystems.gamestudio.game.minesweeper;

import sk.tsystems.gamestudio.game.minesweeper.consoleui.ConsoleUI;
import sk.tsystems.gamestudio.game.minesweeper.core.Field;

/**
 * Main application class.
 */
public class Minesweeper implements Runnable{
	/** User interface. */
	private UserInterface userInterface;

	private static Minesweeper instance;

	private Field field;

	/**
	 * Constructor.
	 */
	public Minesweeper() {
		instance = this;
		userInterface = new ConsoleUI();
		this.field = new Field(10, 10, 10);
	}

	public static Minesweeper getInstance() {
		return instance;
	}

	@Override
	public void run() {
		userInterface.newGameStarted(this.field);
	}
}
