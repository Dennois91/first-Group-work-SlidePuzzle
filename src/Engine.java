import javax.swing.*;
import java.util.*;
import java.util.stream.IntStream;

public class Engine {
	private Hashtable<Integer, Integer> buttonValues;

	private Engine(Hashtable<Integer, Integer> buttonValues, List<JButton> buttons) {
		this.buttonValues = buttonValues;
	}

	public static Engine create(List<JButton> buttons) {
		Hashtable<Integer, Integer> initialButtonValues = new Hashtable<>();
		IntStream.range(1, 17).forEach((i -> initialButtonValues.put(i, i)));
		return new Engine(initialButtonValues, buttons);
	}

	public void moveButtonValue(JButtonPlus buttonId) {
		int id = buttonId.getIndex();
		// Check if button is next to 16
	}

	private boolean isMoveable(int buttonId) {
		Hashtable<Integer, Set<Integer>> validMoves = new Hashtable<>();
		validMoves.put(1, Set.of(2, 5));
		validMoves.put(2, Set.of(1, 3, 6));
		validMoves.put(3, Set.of(2, 4, 7));
		validMoves.put(4, Set.of(3, 8));
		validMoves.put(5, Set.of(1, 6, 9));
		validMoves.put(6, Set.of(2, 5, 7, 10));
		validMoves.put(7, Set.of(3, 6, 8, 11));
		validMoves.put(8, Set.of(4, 7, 12));
		validMoves.put(9, Set.of(5, 10, 13));
		validMoves.put(10, Set.of(6, 9, 11, 14));
		validMoves.put(11, Set.of(7, 10, 12, 15));
		validMoves.put(12, Set.of(8, 11, 16));
		validMoves.put(13, Set.of(9, 14));
		validMoves.put(14, Set.of(10, 13, 15));
		validMoves.put(15, Set.of(11, 14, 16));
		validMoves.put(16, Set.of(12, 15));
		return validMoves.get(getPositionForValue(16)).contains(buttonId);
	}


	private boolean canMove(Square square, Position positionOfEmptyValue) {
		var possibleMoves = getPossibleMoves(positionOfEmptyValue);
		return possibleMoves.containsKey(square.getCurrent());
	}

	private HashMap<Position, Position> getPossibleMoves(Position positionOfEmptyValue) {
		var adjacentPositions = getAdjacentPositions(positionOfEmptyValue);
		var possibleMoves = new HashMap<Position, Position>();
		adjacentPositions.forEach((adjacentPosition -> possibleMoves.put(adjacentPosition, positionOfEmptyValue)));
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
