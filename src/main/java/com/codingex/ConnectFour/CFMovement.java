package com.codingex.ConnectFour;

import java.util.ArrayList;
import java.util.List;

import com.codingex.Movement;

public class CFMovement implements Movement<Integer> {
	private static List<Movement<?>> availableMovements = null;
	
	public static List<Movement<?>> getAvailableMovements() {
		if (availableMovements == null) {
			synchronized(CFMovement.class) {
				if (availableMovements == null) {
					availableMovements = new ArrayList<Movement<?>>(7);
					availableMovements.add(new CFMovement(0));
					availableMovements.add(new CFMovement(1));
					availableMovements.add(new CFMovement(2));
					availableMovements.add(new CFMovement(3));
					availableMovements.add(new CFMovement(4));
					availableMovements.add(new CFMovement(5));
					availableMovements.add(new CFMovement(6));
				}
			}
		}
		return availableMovements;
	}
	
	private int id;
	
	private CFMovement(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
