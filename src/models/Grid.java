package models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Grid<E> {
	private final E[][] elements;

	public Grid(E[][] elements) {
		this.elements = elements;
	}

	public E get(Position position) {
		return elements[position.getX() - 1][position.getY() - 1];
	}

	public void set(Position position, E value) {
		elements[position.getX() - 1][position.getY() - 1] = value;
	}

	public Optional<Position> findPosition(Predicate<E> condition) {
		return getAllPositions().stream()
				.filter(position -> condition.test(get(position))).findFirst();
	}

	public void swap(Position a, Position b) {
		E tempA = get(a);
		set(a, get(b));
		set(b, tempA);
	}

	public void shuffle() {
		var currentPositions = getAllPositions();
		var newPositions = new ArrayList<>(currentPositions);
		Collections.shuffle(newPositions);
		for (int i = 0; i < currentPositions.size(); i++) {
			swap(currentPositions.get(i), newPositions.get(i));
		}
	}

	public List<Position> getAllPositions() {
		List<Position> positions = new ArrayList<>();
		for (int y = 1; y < (elements.length - 1); y++) {
			for (int x = 1; x < (elements[0].length - 1); x++) {
				positions.add(new Position(x, y));
			}
		}
		return positions;
	}

	public void forAll(Consumer<E> action) {
		getAllPositions().stream()
				.map(this::get)
				.forEach(action);
	}
}
