package models;

import java.util.concurrent.atomic.AtomicInteger;

public class ProgressChecker {
	private final Grid<Square> grid;

	public ProgressChecker(Grid<Square> grid) {
		this.grid = grid;
	}

	public void checkProgress() {
		if (squaresAreInOrder()) {
			System.out.println("Grattis big brain!");
			// TODO Congratulate
		}
	}

	private boolean squaresAreInOrder() {
		var positions = grid.getAllPositions();
		AtomicInteger counter = new AtomicInteger(1);
		return positions.stream()
				.limit(positions.size() - 1)
				.map(grid::get)
				.allMatch(square -> Integer.parseInt(square.getText().equals("")
						? "0" :square.getText()) == counter.getAndIncrement());
	}
}
