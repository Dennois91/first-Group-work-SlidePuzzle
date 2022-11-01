package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolvabilityCheckerTest {

	@Test
	@DisplayName("A grid of squares is either solvable or not.")
	void isSolvable() {
		// Given

		Square[][] unSolvableConfiguration = {
				{ new Square(""),new Square("1") },
				{ new Square("2"),new Square("3") },
		};
		Square[][] solvableConfiguration = {
				{ new Square(""),new Square("1") },
				{ new Square("3"),new Square("2") },
		};
		Grid<Square> unSolvableGrid = new Grid<>(unSolvableConfiguration);
		Grid<Square> solvableGrid = new Grid<>(solvableConfiguration);

		var unSolvableSolver = new SolvabilityChecker(unSolvableGrid, new InversionCounter());
		var solvableSolver = new SolvabilityChecker(solvableGrid, new InversionCounter());


		// When
		var unsolvableGridCanBeSolved = unSolvableSolver.isSolvable();
		var solvableGridCanBeSolved = solvableSolver.isSolvable();

		// Then
		assertTrue(solvableGridCanBeSolved);
		assertFalse(unsolvableGridCanBeSolved);
	}
}


