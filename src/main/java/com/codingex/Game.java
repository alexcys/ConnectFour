package com.codingex;

import java.util.List;

/**
 * Implement the main board game control.
 * @author alex
 *
 */

public interface Game {
	/**
	 * Returns true if the game is over.
	 * @return true if the game is over
	 */
	boolean getIsOver();
	
	/**
	 * Returns true if the game is a draw.
	 * @return true if the game is a draw
	 */
	boolean getIsDraw();
	
	/**
	 * Returns the winner of the game. NULL if the game is not
	 * finished yet.
	 * @return the winner of the game
	 */
	Player getWinner();
	
	/**
	 * Returns the current player.
	 * @return the current player
	 */
	Player getCurrentPlayer();
	
	/**
	 * Returns the list of available movements.
	 * @return the list of available movements
	 */
	List<Movement<?>> getAvailableMovements();
	
	/**
	 * Current player performs a movement.
	 * @param movement
	 * @return true if the move is valid.
	 */
	boolean move(Movement<?> movement);
	
	/**
	 * set the UI responsible for drawing
	 * @param ui
	 */
	void setUI(UI ui);
	
	/**
	 * draw the game board using the UI
	 */
	void draw();
}
