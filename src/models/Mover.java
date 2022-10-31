package models;

import java.util.List;
import java.util.function.Predicate;

public class Mover {
	private final Grid<Square> grid;

	public Mover(Grid<Square> grid) {
		this.grid = grid;
	}

	public void moveSquare(Square square) {
		var clickedSquarePosition = getPosition(square.getText());
		var emptySquarePosition = getPosition("");
		if (canMove(clickedSquarePosition)) {
			grid.swap(clickedSquarePosition, emptySquarePosition);
		}
	}

	private Position getPosition(String text) {
		Predicate<Square> textMatches = square1 -> square1.getText().equals(text);
		return grid.findPosition(textMatches)
				.orElseThrow(() -> new RuntimeException("A square with the text could not be found"));
	}

	private boolean canMove(Position position) {
		var positionsThatCanMove = getPositionsThatCanMove();
		return positionsThatCanMove.contains(position);
	}

	private List<Position> getPositionsThatCanMove() {
		var emptySquarePosition = getPosition("");
		var up = new Position(emptySquarePosition.getX(), emptySquarePosition.getY() + 1);
		var down = new Position(emptySquarePosition.getX(), emptySquarePosition.getY() - 1);
		var left = new Position(emptySquarePosition.getX() - 1, emptySquarePosition.getY());
		var right = new Position(emptySquarePosition.getX() + 1, emptySquarePosition.getY());
		return List.of(up, down, left, right);
	}
}
