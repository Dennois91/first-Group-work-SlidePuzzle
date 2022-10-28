import java.util.*;

public class Engine {
	private Square emptySquare;
	private HashMap<Position, Boolean> squaresInCorrectPosition;

	public Engine(Square emptySquare, HashMap<Position, Boolean> squaresInCorrectPosition) {
		this.emptySquare = emptySquare;
		this.squaresInCorrectPosition = squaresInCorrectPosition;
	}

	public void move(Square square) {
		if (canMove(square)) {
			switchSquareTexts(square, emptySquare);
			emptySquare = square;
		}
	}
	
	private void switchSquareTexts(Square a, Square b) {
		var tempTextHolder = a.getText();
		a.setText(b.getText());
		b.setText(tempTextHolder);
	}

	private boolean canMove(Square square) {
		var possibleMoves = getPossibleMoves();
		return possibleMoves.containsKey(square.getCurrentPosition());
	}

	private HashMap<Position, Position> getPossibleMoves() {
		var adjacentPositions = getAdjacentPositions(emptySquare.getCurrentPosition());
		var possibleMoves = new HashMap<Position, Position>();
		adjacentPositions.forEach((adjacentPosition -> possibleMoves.put(adjacentPosition,
				emptySquare.getCurrentPosition())));
		return possibleMoves;
	}

	private List<Position> getAdjacentPositions(Position positionOfEmptyValue) {
		List<Position> adjacentPositions = new ArrayList<>();
		adjacentPositions.add(positionOfEmptyValue.up());
		adjacentPositions.add(positionOfEmptyValue.down());
		adjacentPositions.add(positionOfEmptyValue.left());
		adjacentPositions.add(positionOfEmptyValue.right());
		return adjacentPositions;
	}
}
