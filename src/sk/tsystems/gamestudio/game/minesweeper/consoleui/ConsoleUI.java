package sk.tsystems.gamestudio.game.minesweeper.consoleui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sk.tsystems.gamestudio.game.consoleui.GamesConcoleUI;
import sk.tsystems.gamestudio.game.minesweeper.UserInterface;
import sk.tsystems.gamestudio.game.minesweeper.core.Clue;
import sk.tsystems.gamestudio.game.minesweeper.core.Field;
import sk.tsystems.gamestudio.game.minesweeper.core.GameState;
import sk.tsystems.gamestudio.game.minesweeper.core.Mine;
import sk.tsystems.gamestudio.game.minesweeper.core.Tile;
import sk.tsystems.gamestudio.game.minesweeper.exception.WrongFormatException;

/**
 * Console user interface.
 */
public class ConsoleUI implements UserInterface {
	/** Playing field. */
	private Field field;
	
	private boolean exit = true;

	/** Input reader. */
	private BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in));

	/**
	 * Reads line of text from the reader.
	 * 
	 * @return line as a string
	 */
	private String readLine() {
		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * New game
	 */
	@Override
	public void newGameStarted(Field field) {
		this.field = field;
		System.out.println("Enter X for exit");
		System.out.println("Enter M/m for mark tile");
		System.out.println("Enter O/o for open tile");
		do {
			update();
			System.out.println("Enter input:");
			processInput();
			if (field.getState() == GameState.SOLVED) {
				update();
				new GamesConcoleUI().win("Minesweeper", field.getScore());
				exit = false;
			} else if (field.getState() == GameState.FAILED) {
				update();
				System.out.println("You lose! GAME OVER!!!");
				exit = false;
			}
		} while (exit == true);
	}

	/**
	 * Draw game field
	 */
	@Override
	public void update() {
		char row = 'A';
		int column = 1;
		for (int i = -1; i < field.getRowCount(); i++) {
			for (int j = -1; j < field.getColumnCount(); j++) {
				if ((i == -1) && (j == -1)) {
					System.out.printf("  ");
				} else if (j == -1 && i > -1) {
					System.out.printf(row + " ");
					row++;
				} else if (i == -1 && j > -1) {
					System.out.printf(column + " ");
					column++;
				} else {
					Tile tempTile = field.getTile(i, j);
					switch (tempTile.getState()) {
					case OPEN:
						if (tempTile instanceof Mine) {
							System.out.printf("X ");
						} else if (tempTile instanceof Clue) {
							System.out
									.print(((Clue) tempTile).getValue() + " ");
						}
						break;
					case MARKED:
						System.out.printf("M ");
						break;
					case CLOSED:
						System.out.printf("- ");
						break;
					}
				}
			}
			System.out.println();
		}
		System.out.println("Remaining mine: " + field.getRemainingMineCount());
	}

	/**
	 * Processes user input. Reads line from console and does the action on a
	 * playing field according to input string.
	 */
	private void processInput() {
		try {
			handleInput(readLine());
		} catch (WrongFormatException e) {
			e.printStackTrace();
		}
	}

	public void handleInput(String input) throws WrongFormatException {
		Pattern pattern = Pattern
				.compile("([XxMmOo])([A-Za-z])?(\\d{1,2})?");
		Matcher matcher = pattern.matcher(input);

		if (matcher.matches()) {
			switch (matcher.group(1).toUpperCase()) {
			case "X":
				exit = false;
				return;
			case "M":
				int row = matcher.group(2).toUpperCase().charAt(0) - 'A';
				int column = Integer.parseInt(matcher.group(3)) - 1;
				field.markTile(row, column);
				break;
			case "O":
				int row1 = matcher.group(2).toUpperCase().charAt(0) - 'A';
				int column1 = Integer.parseInt(matcher.group(3)) - 1;
				field.openTile(row1, column1);
				break;
			}
		} else {
			System.out.println("Wrong format input");
			processInput();
		}
	}
}
