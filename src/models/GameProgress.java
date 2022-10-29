package models;

import java.util.HashMap;

public class GameProgress {
	private final HashMap<Position, Boolean> squaresInHomePosition = new HashMap<>();

	public boolean isComplete() {
		return !squaresInHomePosition.containsValue(false);
	}

	public void update(Square square) {
		squaresInHomePosition.put(square.getCurrentPosition(),square.isHome());
	}
}
