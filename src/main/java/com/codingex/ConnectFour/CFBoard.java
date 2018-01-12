package com.codingex.ConnectFour;

import com.codingex.Board;
import com.codingex.Player;

public class CFBoard implements Board {
	/**
	 * Board:
	 * 35 36 37 38 39 40 41
	 * 28 29 30 31 32 33 34
	 * 21 22 23 24 25 26 27
	 * 14 15 16 17 18 19 20
	 *  7  8  9 10 11 12 13
	 *  0  1  2  3  4  5  6
	 */
	
	protected static final int ROWS = 6;
	protected static final int COLS = 7;
	
	protected static final int CONNECTED = 4;
	protected static final int CHECK_LINES[][] = {
		// horizontal
		{ 0,  1,  2,  3,  4,  5,  6},
		{ 7,  8,  9, 10, 11, 12, 13},
		{14, 15, 16, 17, 18, 19, 20},
		{21, 22, 23, 24, 25, 26, 27},
		{28, 29, 30, 31, 32, 33, 34},
		{35, 36, 37, 38, 39, 40, 41},
		// vertical
		{ 0,  7, 14, 21, 28, 35},
		{ 1,  8, 15, 22, 29, 36},
		{ 2,  9, 16, 23, 30, 37},
		{ 3, 10, 17, 24, 31, 38},
		{ 4, 11, 18, 25, 32, 39},
		{ 5, 12, 19, 26, 33, 40},
		{ 6, 13, 20, 27, 34, 41},
		// diagonal (from bottom left to upper right)
		{14, 22, 30, 38},
		{ 7, 15, 23, 31, 39},
		{ 0,  8, 16, 24, 32, 40},
		{ 1,  9, 17, 25, 33, 41},
		{ 2, 10, 18, 26, 34},
		{ 3, 11, 19, 27},
		// diagonal (from bottom right to upper left)
		{ 3, 9, 15, 21},
		{ 4, 10, 16, 22, 28},
		{ 5, 11, 17, 23, 29, 35},
		{ 6, 12, 18, 24, 30, 36},
		{13, 19, 25, 31, 37},
		{20, 26, 32, 38}
	};
	
	protected Player board[];
	protected int colHeight[];	// keep track of the height of each column
	
	public CFBoard() {
		board = new Player[ROWS * COLS];
		for (int i = 0; i < ROWS * COLS; ++i) {
			board[i] = null;
		}
		
		colHeight = new int[COLS];
		for (int col = 0; col < COLS; ++col) {
			colHeight[col] = 0;
		}
	}
	
	public int getRows() {
		return ROWS;
	}
	
	public int getColumns() {
		return COLS;
	}
	
	public Player getOwnerAt(int row, int col) {
		int i = _getIndex(row, col);
		if (i < ROWS * COLS) {
			return board[i];
		}
		return null;
	}
	
	public boolean setOwnerAt(int row, int col, Player player) {
		int i = _getIndex(row, col);
		// safe-guard
		if (i >= ROWS * COLS) {
			return false;
		}
		// check if the cell is occupied
		if (board[i] != null) {
			return false;
		}
		// check if the the cell is on top of the column.
		if (row != colHeight[col]) {
			return false;
		}
		// assign ownership and update column height
		board[i] = player;
		colHeight[col]  = row + 1;
		return true;
	}
	
	private int _getIndex(int row, int col) {
		return row * COLS + col;
	}
	
	protected int getColumnHeight(int col) {
		if (col < COLS) {
			return colHeight[col];
		}
		return -1;
	}
	
	protected boolean checkIsWon() {
		// check line by line
		for (int i = 0; i < CHECK_LINES.length; ++i) {
			// record the first element of the line
			Player prev = board[CHECK_LINES[i][0]];
			int connected = 1;
			// check the remaining elements of the line
			for (int j = 1; j < CHECK_LINES[i].length; ++j) {
				Player curr = board[CHECK_LINES[i][j]];
				if (prev != null && prev == curr) {
					if (++connected >= CONNECTED) {
						return true;
					}
				} else {
					if (CHECK_LINES[i].length - j < CONNECTED) {
						// the remaining elements of this line are not enough
						break;
					}
					prev = curr;
					connected = 1;
				}
			}
		}
		return false;
	}
	
	protected boolean checkIsDrawn() {
		for (int col = 0; col < COLS; ++col) {
			if (colHeight[col] < ROWS) {
				return false;
			}
		}
		return true;
	}
}
