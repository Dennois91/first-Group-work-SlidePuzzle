package controller;

import models.*;
import view.View;

public class Controller {
	private final ProgressChecker progressChecker = new ProgressChecker();
	private final View view;
	private final GridOfSquares squares;
	private final Mover mover;

	public Controller(GridSize gridSize, Mover mover) {
		this.view = new View(gridSize);
		this.squares = view.getSquares();
		this.mover = new Mover(squares);
	}

	public void initView() {
	}

	public void initController() {
		squares.setForAll(square -> square.addActionListener(e -> squareClicked(square)));
	}

	public void squareClicked(Square square) {
		mover.moveSquare(square);
		progressChecker.checkProgress(squares);
	}
}
