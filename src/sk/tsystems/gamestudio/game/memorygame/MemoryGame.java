package sk.tsystems.gamestudio.game.memorygame;

import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame {

	private int rowCount;
	private int columnCount;
	private int[][] tiles;

	public MemoryGame(int rowCount, int columnCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		tiles = new int[rowCount][columnCount];
		generate();
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

	public void generate() {
		int count = rowCount * columnCount;
		ArrayList<Integer> values = new ArrayList<Integer>(count);
		for (int i = 0; i < count/2; i++) {
			values.add(i);
			values.add(i);
		}
		Collections.shuffle(values);
		
		int index = 0;
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				tiles[row][column] = values.get(index);
				index++;
			}
		}
	}

	public void show() {
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				int value = tiles[row][column];
				System.out.printf("%2d", value);
			}
			System.out.println();
		}
	}
}
