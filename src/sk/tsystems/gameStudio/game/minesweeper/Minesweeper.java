package sk.tsystems.gameStudio.game.minesweeper;

import sk.tsystems.gameStudio.game.minesweeper.consoleui.ConsoleUI;
import sk.tsystems.gameStudio.game.minesweeper.core.Field;

/**
 * Main application class.
 */
public class Minesweeper implements Runnable{
	/** User interface. */
	private UserInterface userInterface;

	private long startMillis = System.currentTimeMillis();

	private BestTimes bestTimes;

	private static Minesweeper instance;
	
	private Settings settings;

	private Field field;

	/**
	 * Constructor.
	 */
	public Minesweeper() {
		instance = this;
		userInterface = new ConsoleUI();
		this.field = new Field(10, 10, 10);
//		userInterface.newGameStarted(field);
	}

	public int getPlayingSecond() {
		long time = System.currentTimeMillis() - startMillis;
		return (int) time % 1000;
	}

	public BestTimes getBestTimes() {
		return bestTimes;
	}

	public static Minesweeper getInstance() {
		return instance;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	@Override
	public void run() {
		userInterface.newGameStarted(this.field);
//		new Minesweeper();
		
	}
}
