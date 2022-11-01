package main;

import controller.Controller;
import models.*;
import view.View;

import java.util.concurrent.atomic.AtomicInteger;

public class Game {
	private final Controller controller;

	public Game(Controller controller) {
		this.controller = controller;
	}

	public static Game easy() {
		return createGame(3, 3);
	}

	public static Game normal() {
		return createGame(4, 4);
	}

	public static Game hard() {
		return createGame(8, 8);
	}

	public static Game cheat() {
		return createGame(2, 2);
	}

	private static Game createGame(int columns, int rows) {
		Grid<Square> grid = new Grid<>(new Square[columns][rows]);
		createSquares(grid);
		SolvabilityChecker solvabilityChecker = new SolvabilityChecker(grid,new InversionCounter());
		initializeGridValues(grid, solvabilityChecker);
		View view = new View(grid);
		ProgressChecker progressChecker = new ProgressChecker(grid);
		Mover mover = new Mover(grid);
		Controller controller = new Controller(view, progressChecker, mover);
		return new Game(controller);
	}

	public void run() {
		controller.initializeController();
	}

	private static void initializeGridValues(Grid<Square> grid, SolvabilityChecker solvabilityChecker) {
		var positions = grid.getAllPositions();
		var counter = new AtomicInteger(1);
		positions.stream()
				.limit(positions.size() - 1)
				.map(grid::get)
				.forEach(square -> square.setText(String.valueOf(counter.getAndIncrement())));

		shuffleGridValues(grid, solvabilityChecker);
	}

	private static void shuffleGridValues(Grid<Square> grid, SolvabilityChecker solvabilityChecker) {
		grid.shuffle();
		while (!solvabilityChecker.isSolvable()) {
			grid.shuffle();
		}
	}

	private static void createSquares(Grid<Square> grid) {

		var positions = grid.getAllPositions();
		positions.forEach(position -> grid.set(position,new Square("")));
		grid.shuffle();
	}
}
