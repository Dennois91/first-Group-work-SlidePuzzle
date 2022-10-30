package models;

import java.util.concurrent.atomic.AtomicInteger;

public class ProgressChecker {

	public void checkProgress(GridOfSquares squares) {
		if (squaresAreInOrder(squares)) {
			// TODO Congratulate
		}
	}

	private boolean squaresAreInOrder(GridOfSquares squares) {
		AtomicInteger counter = new AtomicInteger(1);
		return squares.stream()
				.limit(squares.getCapacity() - 1)
				.allMatch(square -> Integer.parseInt(square.getText()) == counter.getAndIncrement());
	}
}
