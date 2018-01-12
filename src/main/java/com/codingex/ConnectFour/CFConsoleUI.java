package com.codingex.ConnectFour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import com.codingex.Board;
import com.codingex.Game;
import com.codingex.Movement;
import com.codingex.Player;
import com.codingex.UI;

public class CFConsoleUI implements UI {
	public void drawBoard(Board board) {
		for (int row = board.getRows() - 1; row >= 0; --row) {
			for (int col = 0; col < board.getColumns(); ++col) {
				Player owner = board.getOwnerAt(row, col);
				System.out.print("|");
				System.out.print(owner == null ? ' ' : owner.getToken());
				if (col == board.getColumns() - 1) {
					System.out.println("|");
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Movement<?>> movementMap = new HashMap<Integer, Movement<?>>(7);
		Game game = new CFGame();
		
		game.setUI(new CFConsoleUI());
		for (Movement<?> m : game.getAvailableMovements()) {
			movementMap.put((Integer)m.getId(), m);
		}
		
		while (true) {
			game.draw();
			System.out.println();
			
			if (game.getIsOver()) {
				if (game.getIsDraw()) {
					System.out.println("Draw!");
				} else {
					System.out.printf("%s wins!", game.getWinner().getName());
				}
				break;
			}
			
			System.out.printf("%s - choose column (1-7): ", game.getCurrentPlayer().getName());
			try {
	            int i = Integer.parseInt(br.readLine());
	            Movement<?> movement = movementMap.get(i-1);
	            if (movement != null) {
	            		if (game.move(movement)) {
	            			continue;
	            		}
	            }
	        } catch (NumberFormatException nfe) {
	            ;
	        }
            System.out.println("Invalid input!");
		}
	}
}
