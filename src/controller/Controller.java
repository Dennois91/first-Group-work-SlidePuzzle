package controller;

import models.GameProgress;
import models.GridSize;
import models.Square;
import view.View;

import java.util.*;

public class Controller {
	private Square emptySquare;

	private final GameProgress gameProgress = new GameProgress(emptySquare);
	private final View view;
	private final GridSize gridSize;

	public Controller(Square emptySquare, GridSize gridSize) {
		this.emptySquare = emptySquare;
		this.gridSize = gridSize;
		this.view = new View(gridSize);
	}

	public void initView() {

	}

	public void initController() {
		List<Square> squares = view.getSquares();
		squares.forEach(square -> square.addActionListener(e -> move(square)));

	}

	public void move(Square square) {
		if (square.canMove(emptySquare)) {
			emptySquare = square.switchSquareData(emptySquare);
			gameProgress.update(emptySquare);
		}
		if (gameProgress.isComplete()) {
			// TODO show congratulations
		}
	}


}
