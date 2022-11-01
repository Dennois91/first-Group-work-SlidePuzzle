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
		var columnCountIsOdd = isOdd.test(grid.getCols());
		var inversionCountIsOdd = isOdd.test(inversionCounter.count(getNumbersInGrid()));
		var emptySquareIsOnInEvenRow = isOdd.test(getBlankSquareDistanceFromBottom());

		// If N is odd, then puzzle instance is solvable if number of inversions is even in the input state.
		if (columnCountIsOdd && !inversionCountIsOdd) {
			return true;
		}

		// If N is even, puzzle instance is solvable if
		if (!columnCountIsOdd) {

			/*the blank is on an even row counting from the bottom (second-last, fourth-last, etc.) and number of
			inversions
			is odd.*/
			if (emptySquareIsOnInEvenRow && inversionCountIsOdd) {
				return true;
			}

			/*the blank is on an odd row counting from the bottom (last, third-last, fifth-last, etc.) and number of
			inversions is even.*/
			return !emptySquareIsOnInEvenRow && !inversionCountIsOdd;
		}

		/*For all other cases, the puzzle instance is not solvable.*/
		return false;
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
