package com.codingex;

/**
 * Implement to define board structure of the board game.
 * For instance, ConnectFour has a 6 x 7 board.
 * @author alex
 *
 */
public interface Board {
	/**
	 * Returns no. of row in the board.
	 * @return
	 */
	int getRows();
	
	/**
	 * Returns no. of column in the board.
	 * @return
	 */
	int getColumns();
	
	/**
	 * Returns the owner of the cell at the given position.
	 * NULL if the cell is not occupied yet.
	 */
	Player getOwnerAt(int row, int col);
	
	/**
	 * Set the owner of the cell at the given position.
	 * @param x
	 * @param y
	 * @param player
	 * @return true if the ownership can be set.
	 */
	boolean setOwnerAt(int row, int col, Player player);
}
