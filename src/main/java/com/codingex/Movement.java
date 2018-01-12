package com.codingex;

/**
 * Implement to define the movement available of the board game.
 * For example, ConnectFour should use Movement<int> to allow
 * choosing column 1-7.
 * @author alex
 *
 * @param <T>
 */
public interface Movement<T> {
	/**
	 * Returns the identifier of the movement.
	 * @return the identifier of the movement
	 */
	T getId();
}
