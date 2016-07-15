package sk.tsystems.gameStudio.game.stones.consoleui;

import java.util.Scanner;

import sk.tsystems.gameStudio.game.stones.core.Field;

public class ConsoleUI {
	private Field field;
	private boolean exit;
	private Scanner scanner;

	public ConsoleUI() {
		if (field == null) {
			newField();
		}
		scanner = new Scanner(System.in);
	}
	
	public void run() {
		System.out.println("Welcome in game STONES!!!");
		System.out
				.println("Move with 'number' or 'w, a, s, d' or 'up, left, down, right'");
		System.out.println("For exit enter 'x' or 'exit'");
		do {
			show();
			processInput();
		} while (!field.isSolved() && !exit);
		if (field.isSolved()) {
			System.out.println("You won the Game!");
		}
	}

	public void show() {
		System.out.printf("Time: %03d s\n", field.getPlayingSeconds());
		for (int row = 0; row < field.getRowCount(); row++) {
			for (int column = 0; column < field.getColumnCount(); column++) {
				int value = field.getValueAt(row, column);
				if (value == Field.EMPTY_CELL) {
					System.out.printf("  ");
				} else {
					System.out.printf("%2d", value);
				}
				System.out.print("  ");
			}
			System.out.println();
		}
	}

	private void processInput() {
		System.out.print("Enter input: ");
		String line = scanner.nextLine().toLowerCase().trim();

		try {
			int value = Integer.parseInt(line);
			if (!field.move(value)) {
				field.move(value);
			}
		} catch (NumberFormatException e) {
		}

		switch (line) {
		case "w":
		case "up":
			field.moveUp();
			break;
		case "a":
		case "left":
			field.moveLeft();
			break;
		case "s":
		case "down":
			field.moveDown();
			break;
		case "d":
		case "right":
			field.moveRight();
			break;
		case "x":
		case "exit":
			exit = true;
		case "n":
		case "new":
			newField();
			break;
		default:
			break;
		}
	}

	private void newField() {
		field = new Field(4, 4);
	}
}
