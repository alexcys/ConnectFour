package com.codingex;

/**
 * Implement to define the players available for the board game.
 * @author alex
 *
 */
public interface Player {
	/**
	 * Returns the identifier of the player.
	 * @return identifier of the player.
	 */
	String getName();
	char getToken();
}
