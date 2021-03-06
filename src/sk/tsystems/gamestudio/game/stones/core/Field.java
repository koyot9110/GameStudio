package sk.tsystems.gamestudio.game.stones.core;

import java.util.Random;

import sk.tsystems.gamestudio.game.stones.exception.StonesException;

public class Field {

	public static final int EMPTY_CELL = -1;

	private final int[][] tiles;

	private final int rowCount;

	private final int columnCount;

	private long startMillis;

	Random rnd = new Random();

	public Field(int rowCount, int columnCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		tiles = new int[rowCount][columnCount];
		generate();
		shuffle();
		startMillis = System.currentTimeMillis();
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public int getValueAt(int row, int column) {
		return tiles[row][column];
	}

	private void generate() {
		int count = 1;
		for (int row = 0; row < getRowCount(); row++) {
			for (int column = 0; column < getColumnCount(); column++) {
				tiles[row][column] = count;
				count++;
			}
		}
		tiles[getRowCount() - 1][getColumnCount() - 1] = EMPTY_CELL;
	}

	private void shuffle() {
		int increment = 0;
		do {
			int random = rnd.nextInt(4);
			switch (random) {
			case 0:
				moveUp();
				break;
			case 1:
				moveDown();
				break;
			case 2:
				moveLeft();
				break;
			case 3:
				moveRight();
				break;
			default:
				break;
			}
			increment++;
		} while (increment < 50);
	}

	private Position getPositionOf(int value) {
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				if (tiles[row][column] == value) {
					return new Position(row, column);
				}
			}
		}
		return null;
	}

	private Position getEmptyPosition() {
		return getPositionOf(EMPTY_CELL);
	}

	private void move(int dr, int dc) {
		Position emptyPosition = getEmptyPosition();
		int er = emptyPosition.getRow();
		int ec = emptyPosition.getColumn();
		if (er + dr >= 0 && er + dr < rowCount && ec + dc >= 0 && ec + dc < columnCount) {
			tiles[er][ec] = tiles[er + dr][ec + dc];
			tiles[er + dr][ec + dc] = EMPTY_CELL;
		}
	}

	public void moveDown() {
		move(-1, 0);
	}

	public void moveUp() {
		move(1, 0);
	}

	public void moveRight() {
		move(0, -1);
	}

	public void moveLeft() {
		move(0, 1);
	}

	public boolean move(int value) {
		Position pos = getPositionOf(value);
		if (pos != null) {
			Position emptyPosition = getEmptyPosition();
			int dr = pos.getRow() - emptyPosition.getRow();
			int dc = pos.getColumn() - emptyPosition.getColumn();

			if ((Math.abs(dr) == 1 && dc == 0) || (dr == 0 && Math.abs(dc) == 1)) {
				move(dr, dc);
				return true;
			}
		}
		return false;
	}

	public boolean isSolved() {
		int value = 1;
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				if (tiles[row][column] != value) {
					return false;
				}
				value++;
				if (value == rowCount * columnCount) {
					return true;
				}
			}
		}
		throw new StonesException("isSolved Exception");
	}

	public int getPlayingSeconds() {
		return (int) ((System.currentTimeMillis() - startMillis) / 100);
	}

	public int getScore() {
		int score = 100000 / getPlayingSeconds();
		return score;
	}
}
