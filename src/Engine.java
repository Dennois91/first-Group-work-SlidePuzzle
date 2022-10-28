import java.util.*;

public class Engine {
	private Square emptySquare;
	private final HashMap<Position, Boolean> squaresInHomePosition;

	public Engine(Square emptySquare, HashMap<Position, Boolean> squaresInHomePosition) {
		this.emptySquare = emptySquare;
		this.squaresInHomePosition = squaresInHomePosition;
	}

	public void move(Square square) {
		if (canMove(square)) {
			switchSquares(square, emptySquare);
		}
		if (gameIsWon()) {
			// TODO Congratulations
		}
	}

	private boolean gameIsWon() {
		return !squaresInHomePosition.containsValue(false);
	}

	private void switchSquares(Square a, Square b) {
		switchSquarePositions(a,b);
		switchSquareTexts(a,b);
		emptySquare = a;
		squaresInHomePosition.put(b.getCurrentPosition(),b.isHome());
	}

	private void switchSquarePositions(Square a, Square b) {
		var tempPositionHolder = a.getCurrentPosition();
		a.setCurrentPosition(b.getCurrentPosition());
		b.setCurrentPosition(tempPositionHolder);
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
