package com.codingex.ConnectFour;

import java.util.List;

import com.codingex.Game;
import com.codingex.Movement;
import com.codingex.Player;
import com.codingex.UI;

public class CFGame implements Game {

	// define two players P1 and P2
	protected final Player P1 = new Player() {
		public String getName() {
			return "Player 1 [RED]";
		}
		public char getToken() {
			return 'R';
		}
	};
	protected final Player P2 = new Player() {
		public String getName() {
			return "Player 2 [GREEN]";
		}
		public char getToken() {
			return 'G';
		}
	};
	
	protected boolean isOver;
	protected boolean isDraw;
	protected Player winner;
	protected Player currentPlayer;
	
	protected CFBoard board;
	
	protected UI ui;
	
	public CFGame() {
		isOver = false;
		isDraw = false;
		winner = null;
		currentPlayer = P1;
		board = new CFBoard();
	}
	
	public boolean getIsOver() {
		return isOver;
	}

	public boolean getIsDraw() {
		return isDraw;
	}

	public Player getWinner() {
		return winner;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public List<Movement<?>> getAvailableMovements() {
		return CFMovement.getAvailableMovements();
	}
	
	public boolean move(Movement<?> movement) {
		if (!(movement instanceof CFMovement)) {
			return false;
		}
		
		int col = (Integer)movement.getId();
		int row = board.getColumnHeight(col);
		boolean ret = board.setOwnerAt(row, col, currentPlayer);
		if (!ret) {
			return false;
		}
		
		nextTurn();
		
		return ret;
	}

	void nextTurn() {
		// check whether game is over
		if (board.checkIsWon()) {
			isOver = true;
			winner = currentPlayer;
		} else if (board.checkIsDrawn()) {
			isOver = true;
			isDraw = true;
		} else {
			currentPlayer = (currentPlayer == P1) ? P2 : P1;
		}
	}
	
	public void setUI(UI ui) {
		this.ui = ui;
	}
	
	public void draw() {
		if (ui != null) {
			ui.drawBoard(board);
		}
	}
}
