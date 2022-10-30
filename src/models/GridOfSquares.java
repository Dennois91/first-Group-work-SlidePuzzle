package models;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class GridOfSquares {
	private final Square[][] squares; // TODO Need to change stuff since the array indexes starts at 0.

	public GridOfSquares(Square[][] squares) {
		this.squares = squares;
	}

	public Square getEmptySquare() {
		return stream().filter(square -> square.getText().equals(""))
				.reduce((a, b) -> {
					throw new IllegalStateException("Found more than one empty square");
				})
				.orElseThrow();
	}

	public Square getSquare(Position position) {
		return squares[position.getX()][position.getY()];
	}

	public void setSquare(Position position, Square square) {
		squares[position.getX()][position.getY()] = square;
	}

	public Stream<Square> stream() {
		return Arrays.stream(squares)
				.flatMap(Arrays::stream);
	}

	public int getCapacity() {
		return squares.length*squares[1].length;
	}

	public Position getPosition(Square square) {
		long positionInStream = stream()
				.takeWhile(not(square::equals))
				.count() + 1;

		var y = positionInStream % squares[1].length;
		var x = (positionInStream - y) / squares[1].length;
		return new Position((int) x, (int) y);
	}

	public List<Square> getAdjacentSquares(Square square) {
		return getAdjacentPositions(getPosition(square)).stream()
				.map(this::getSquare)
				.collect(Collectors.toList());
	}

	private List<Position> getAdjacentPositions(Position position) {
		var up = new Position(position.getX(), position.getY() + 1);
		var down = new Position(position.getX(), position.getY() - 1);
		var left = new Position(position.getX() - 1, position.getY());
		var right = new Position(position.getX() + 1, position.getY());
		var adjacentPositions = List.of(up, down, left, right);
		return removePositionsOutsideOfGrid(adjacentPositions);
	}

	private List<Position> removePositionsOutsideOfGrid(List<Position> positions) {
		Predicate<Position> isWithinHorizontalRange = (p) -> (p.getX() >= 0) && (p.getX() <= squares[1].length);
		Predicate<Position> isWithinVerticalRange = (p) -> (p.getY() >= 0) && (p.getY() <= squares.length);
		return positions.stream()
				.filter(isWithinHorizontalRange)
				.filter(isWithinVerticalRange)
				.collect(Collectors.toList());
	}

	public void swapSquares(Square a, Square b) {
		var positionA = getPosition(a);
		var positionB = getPosition(b);
		setSquare(positionA, b);
		setSquare(positionB, a);
	}

	public void setForAll(Consumer<Square> setAttribute) {
		stream().forEach(setAttribute);
	}
}
