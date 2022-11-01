package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoverTest {
	Grid<Square> grid;
	Mover mover;

	@BeforeEach
	void setup() {
		var squareArray = new Square[2][2];
		grid = new Grid<>(squareArray);
		grid.set(new Position(1,1), new Square("1"));
		grid.set(new Position(1,2), new Square("2"));
		grid.set(new Position(2,1), new Square("3"));
		grid.set(new Position(2,2), new Square(""));
		mover = new Mover(grid);
	}

	@Test
	@DisplayName("A square can move if it is next to the empty square.")
	void moveSquare() {
		// Given


		// When
		mover.moveSquare(grid.get(new Position(2,1)));
		var three = grid.get(new Position(2,2)).getText();
		var empty = grid.get(new Position(2,1)).getText();

		// Then
		assertEquals("3",three);
		assertEquals("",empty);
	}
	@Test
	@DisplayName("A square can not move if it is not next to the empty square.")
	void moveSquare_2() {
		// Given


		// When
		mover.moveSquare(grid.get(new Position(1,1)));
		var two = grid.get(new Position(1,2)).getText();
		var three = grid.get(new Position(2,1)).getText();

		// Then
		assertEquals("2",two);
		assertEquals("3",three);
	}
}