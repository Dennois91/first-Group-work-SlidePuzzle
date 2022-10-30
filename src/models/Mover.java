package models;

public class Mover {
	private final GridOfSquares squares;

	public Mover(GridOfSquares squares) {
		this.squares = squares;
	}

	public void moveSquare(Square square) {
		if (canMove(square)) {
			squares.swapSquares(square, squares.getEmptySquare());
		}
	}

	private boolean canMove(Square square) {
		var adjacentSquares = squares.getAdjacentSquares(square);
		return adjacentSquares.stream()
				.anyMatch(adjacentSquare -> adjacentSquare.equals(squares.getEmptySquare()));
	}
}
