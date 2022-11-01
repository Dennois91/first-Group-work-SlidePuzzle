package controller;

import main.Game;
import models.*;
import view.View;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Controller {
    private final ProgressChecker progressChecker;
    private final View view;
    private final Mover mover;
    private String difficulty = null;
    private int counter=1;

    public Controller(View view, ProgressChecker progressChecker, Mover mover) {
        this.view = view;
        this.mover = mover;
        this.progressChecker = progressChecker;
    }


    public void initializeController() {
        view.getSquareGrid().forAll(square -> square.addActionListener(e -> squareClicked(square)));
        view.getCheatButton().addActionListener(e -> cheatButtonClicked());
        view.getNewGameButton().addActionListener(e -> NewGameButtonClicked());
        view.getEasy().addActionListener(this::Difficulty);
        view.getNormal().addActionListener(this::Difficulty);
        view.getHard().addActionListener(this::Difficulty);

    }

    private void cheatButtonClicked() {
        view.dispose();
        Game.cheat().run();
    }

    private void NewGameButtonClicked() {

        if (Objects.equals(difficulty, null)){
            view.setMessageLabelText("Choose difficulty first!");
            view.setMovesCounter("");
        }
        if (Objects.equals(difficulty, "easy")) {
            view.dispose();
            Game.easy().run();
        }
        if (Objects.equals(difficulty, "normal")) {
            view.dispose();
            Game.normal().run();
        }
        if (Objects.equals(difficulty, "hard")) {
            view.dispose();
            Game.hard().run();
        }
    }

    private void Difficulty(ActionEvent e) {
        difficulty = (e.getActionCommand());
    }

    public void squareClicked(Square square) {
        mover.moveSquare(square);
        view.setMovesCounter(counter);
        counter++;
        if (progressChecker.checkProgress())
            view.setMessageLabelText("Congratulations. You win!");
        view.updatePanel();
    }
}