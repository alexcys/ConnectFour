package com.codingex.ConnectFour;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codingex.Board;
import com.codingex.Player;

public class CFConsoleUITest {
	CFConsoleUI ui;
	Board board;
	Player player1;
	Player player2;
	ByteArrayOutputStream out;
	
	@Before
	public void createBoard() {
		ui = new CFConsoleUI();
		board = new Board() {
			Player players[][] = new Player[6][7];
			
			public int getRows() {
				return 6;
			}
			public int getColumns() {
				return 7;
			}
			public Player getOwnerAt(int row, int col) {
				return players[row][col];
			}
			public boolean setOwnerAt(int row, int col, Player player) {
				players[row][col] = player;
				return true;
			}
		};
		player1 = new Player() {
			public String getName() {
				return "Player 1 [RED]";
			}
			public char getToken() {
				return 'R';
			}
		};
		player2 = new Player() {
			public String getName() {
				return "Player 2 [GREEN]";
			}
			public char getToken() {
				return 'G';
			}
		};
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}
	
	@After
	public void cleanUp() {
		System.setOut(null);
	}
	
	@Test
	public void testDrawEmptyBoard() {
		ui.drawBoard(board);
		String expected =
			"| | | | | | | |\n" +
			"| | | | | | | |\n" +
			"| | | | | | | |\n" +
			"| | | | | | | |\n" +
			"| | | | | | | |\n" +
			"| | | | | | | |\n";
		assertEquals(expected, out.toString());
		System.out.println(expected);
		System.out.println(out.toString());
	}
	
	@Test
	public void testDrawBoard() {
		board.setOwnerAt(0, 3, player1);
		board.setOwnerAt(1, 3, player2);
		board.setOwnerAt(0, 4, player1);
		board.setOwnerAt(1, 4, player2);
		board.setOwnerAt(0, 2, player1);
		board.setOwnerAt(0, 1, player2);
		board.setOwnerAt(0, 5, player1);
		ui.drawBoard(board);
		String expected =
			"| | | | | | | |\n" +
			"| | | | | | | |\n" +
			"| | | | | | | |\n" +
			"| | | | | | | |\n" +
			"| | | |G|G| | |\n" +
			"| |G|R|R|R|R| |\n";
		assertEquals(expected, out.toString());
		System.out.println(expected);
		System.out.println(out.toString());
	}
}
