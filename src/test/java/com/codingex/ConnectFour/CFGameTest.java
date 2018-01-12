package com.codingex.ConnectFour;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.codingex.Movement;

public class CFGameTest {
	CFGame game;
	HashMap<Integer, Movement<?>> movementMap;
	
	@Before
	public void setup() {
		game = new CFGame();
		movementMap = new HashMap<Integer, Movement<?>>(7);
		for (Movement<?> m : game.getAvailableMovements()) {
			movementMap.put((Integer)m.getId(), m);
		}
	}
	
	@Test
	public void testNewGame() {
		assertFalse(game.getIsOver());
		assertFalse(game.getIsDraw());
		assertEquals(null, game.getWinner());
		assertEquals(game.P1, game.getCurrentPlayer());
	}

	@Test
	public void testNextTurn() {
		game.move(movementMap.get(0));
		assertEquals(game.P2, game.getCurrentPlayer());
	}
	
	@Test
	public void testAlternativeTurn() {
		assertEquals(game.P1, game.getCurrentPlayer());
		game.move(movementMap.get(0));
		assertEquals(game.P2, game.getCurrentPlayer());
		game.move(movementMap.get(1));
		assertEquals(game.P1, game.getCurrentPlayer());
		game.move(movementMap.get(0));
		assertEquals(game.P2, game.getCurrentPlayer());
		game.move(movementMap.get(1));
		assertEquals(game.P1, game.getCurrentPlayer());
		game.move(movementMap.get(0));
		assertEquals(game.P2, game.getCurrentPlayer());
		game.move(movementMap.get(1));
		assertEquals(game.P1, game.getCurrentPlayer());
	}
	
	@Test
	public void testGameWin() {
		game.move(movementMap.get(4));
		game.move(movementMap.get(4));
		game.move(movementMap.get(5));
		game.move(movementMap.get(5));
		game.move(movementMap.get(3));
		game.move(movementMap.get(2));
		game.move(movementMap.get(6));
		assertTrue(game.getIsOver());
		assertFalse(game.getIsDraw());
		assertEquals(game.P1, game.getWinner());
	}
}
