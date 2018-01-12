package com.codingex.ConnectFour;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.codingex.Player;

public class CFBoardTest {
	CFBoard board;
	Player player1;
	Player player2;
	
	@Before
	public void setup() {
		board = new CFBoard();	
		player1 = new Player() {
			public String getName() {
				return "Player 1 [RED]";
			}
			public char getToken() {
				return 'R';
			}
		};
		player1 = new Player() {
			public String getName() {
				return "Player 2 [GREEN]";
			}
			public char getToken() {
				return 'G';
			}
		};
	}
	
	@Test
	public void testNewBoard() {
		assertEquals(6, board.getRows());
		assertEquals(7, board.getColumns());
		assertEquals(0, board.getColumnHeight(0));
		assertEquals(0, board.getColumnHeight(1));
		assertEquals(0, board.getColumnHeight(2));
		assertEquals(0, board.getColumnHeight(3));
		assertEquals(0, board.getColumnHeight(4));
		assertEquals(0, board.getColumnHeight(5));
		assertEquals(0, board.getColumnHeight(6));
		assertFalse(board.checkIsWon());
		assertFalse(board.checkIsDrawn());
	}
	
	@Test
	public void testSetOwner() {
		assertTrue(board.setOwnerAt(0, 0, player1));
		assertFalse(board.setOwnerAt(2, 0, player2));
		assertTrue(board.setOwnerAt(1, 0, player2));
		assertFalse(board.setOwnerAt(1, 0, player1));
	}
	
	@Test
	public void testColumnHeight() {
		board.setOwnerAt(0, 0, player1);
		assertEquals(1, board.getColumnHeight(0));
		board.setOwnerAt(1, 0, player2);
		assertEquals(2, board.getColumnHeight(0));
		board.setOwnerAt(0, 3, player1);
		assertEquals(0, board.getColumnHeight(1));
		assertEquals(0, board.getColumnHeight(2));
		assertEquals(1, board.getColumnHeight(3));
		assertEquals(0, board.getColumnHeight(4));
		assertEquals(0, board.getColumnHeight(5));
		assertEquals(0, board.getColumnHeight(6));
	}
	
	@Test
	public void testCheckIsWonHorizontal() {
		board.setOwnerAt(0, 1, player1);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(0, 2, player1);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(0, 3, player1);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(0, 4, player1);
		assertTrue(board.checkIsWon());
		assertFalse(board.checkIsDrawn());
	}
	
	@Test
	public void testCheckIsWonVertical() {
		board.setOwnerAt(0, 1, player1);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(1, 1, player1);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(2, 1, player1);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(3, 1, player1);
		assertTrue(board.checkIsWon());
		assertFalse(board.checkIsDrawn());
	}
	
	@Test
	public void testCheckIsWonDiagonal() {
		board.setOwnerAt(0, 1, player1);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(0, 2, player2);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(1, 2, player1);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(0, 3, player2);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(0, 4, player1);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(1, 3, player2);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(2, 3, player1);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(1, 4, player2);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(0, 5, player1);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(2, 4, player2);
		assertFalse(board.checkIsWon());
		board.setOwnerAt(3, 4, player1);
		assertTrue(board.checkIsWon());
		assertFalse(board.checkIsDrawn());
	}
	
	@Test
	public void testCheckIsDrawn() {
		board.setOwnerAt(0, 0, player1); board.setOwnerAt(0, 1, player2);
		board.setOwnerAt(1, 0, player1); board.setOwnerAt(1, 1, player2);
		board.setOwnerAt(2, 0, player1); board.setOwnerAt(2, 1, player2);
		board.setOwnerAt(0, 2, player1); board.setOwnerAt(0, 3, player2);
		board.setOwnerAt(1, 2, player1); board.setOwnerAt(1, 3, player2);
		board.setOwnerAt(2, 2, player1); board.setOwnerAt(2, 3, player2);
		board.setOwnerAt(0, 4, player1); board.setOwnerAt(0, 5, player2);
		board.setOwnerAt(1, 4, player1); board.setOwnerAt(1, 5, player2);
		board.setOwnerAt(2, 4, player1); board.setOwnerAt(2, 5, player2);
		board.setOwnerAt(0, 6, player1); board.setOwnerAt(3, 0, player2);
		board.setOwnerAt(1, 6, player1); board.setOwnerAt(4, 0, player2);
		board.setOwnerAt(2, 6, player1); board.setOwnerAt(5, 0, player2);
		board.setOwnerAt(3, 1, player1); board.setOwnerAt(3, 2, player2);
		board.setOwnerAt(4, 1, player1); board.setOwnerAt(4, 2, player2);
		board.setOwnerAt(5, 1, player1); board.setOwnerAt(5, 2, player2);
		board.setOwnerAt(3, 3, player1); board.setOwnerAt(3, 4, player2);
		board.setOwnerAt(4, 3, player1); board.setOwnerAt(4, 4, player2);
		board.setOwnerAt(5, 3, player1); board.setOwnerAt(5, 4, player2);
		board.setOwnerAt(3, 5, player1); board.setOwnerAt(3, 6, player2);
		board.setOwnerAt(4, 5, player1); board.setOwnerAt(4, 6, player2);
		board.setOwnerAt(5, 5, player1); board.setOwnerAt(5, 6, player2);
		assertFalse(board.checkIsWon());
		assertTrue(board.checkIsDrawn());
	}
}
