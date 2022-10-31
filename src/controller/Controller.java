package controller;

import main.Game;
import models.*;
import view.View;

public class Controller {
	private final ProgressChecker progressChecker;
	private final View view;
	private final Mover mover;

	public Controller(View view, ProgressChecker progressChecker, Mover mover) {
		this.view = view;
		this.mover = mover;
		this.progressChecker = progressChecker;
	}

	public void initView() {

	}

	public void initializeController() {
		view.getSquareGrid().forAll(square -> square.addActionListener(e -> squareClicked(square)));
		view.getCheatButton().addActionListener(e -> cheatButtonClicked());
	    view.getNewGameButton().addActionListener(e -> NewGameButtonClicked());
	}

	private void cheatButtonClicked() {
		Game.cheat().run();
	}

	private void NewGameButtonClicked() {
		view.dispose();
		Game.normal().run();
		// TODO Create a new game
	}

	public void squareClicked(Square square) {
		mover.moveSquare(square);
		progressChecker.checkProgress();
		view.updatePanel();

	}
}