package models;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SolvabilityChecker {
	private final Grid<Square> grid;
	private final InversionCounter inversionCounter;

	public SolvabilityChecker(Grid<Square> grid, InversionCounter inversionCounter) {
		this.grid = grid;
		this.inversionCounter = inversionCounter;
	}

	public boolean isSolvable() {
		Predicate<Integer> isOdd = n -> (n & 1) != 0;
		var initialStateInversionCount = inversionCounter.count(getNumbersInGrid());
		var goalStateInversionCount = 0;
		var blankSquareDistanceFromBottom = getBlankSquareDistanceFromBottom();

		return (isOdd.test(initialStateInversionCount+blankSquareDistanceFromBottom) == isOdd.test(goalStateInversionCount));

	}

	private int getBlankSquareDistanceFromBottom() {
		return grid.stream()
				.filter(square -> square.getText().equals(""))
				.map(square -> grid.findPosition(square::equals))
				.flatMap(Optional::stream)
				.map(position -> grid.getRows() - position.getY()).findFirst()
				.orElseThrow(() -> new RuntimeException("An empty square could not be found"));
	}

	private List<Integer> getNumbersInGrid() {
		return grid.stream()
				.map(AbstractButton::getText)
				.filter(text -> !text.equals(""))
				.map(Integer::parseInt).toList();
	}
}
