package view;

import models.Grid;
import models.Square;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    Grid<Square> squareGrid;


    //Panel layouts
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();

    //main.Game Buttons


    //Manipulate game buttons
    JButton newGame = new JButton("New game");
    JButton cheatGame = new JButton("Cheat mode");
    JRadioButton easy = new JRadioButton("Easy");
    JRadioButton normal = new JRadioButton("Normal");
    JRadioButton hard = new JRadioButton("Hard");
    ButtonGroup levels = new ButtonGroup();

    //main.Game labels
    JLabel movesCounter = new JLabel(String.valueOf(0));
    JLabel messageLabel = new JLabel("Number of moves tried is:");


    public View(Grid<Square> squareGrid) {

        this.squareGrid = squareGrid;

        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        northPanel.add(messageLabel);
        northPanel.add(movesCounter);
        northPanel.setBackground(Color.YELLOW);

        centerPanel.setLayout(new GridLayout(squareGrid.getRows(), squareGrid.getCols()));

        squareGrid.forAll(square -> centerPanel.add(square));

        levels.add(easy);
        levels.add(normal);
        levels.add(hard);
        easy.setBackground(Color.yellow);
        normal.setBackground(Color.yellow);
        hard.setBackground(Color.yellow);
        easy.setActionCommand("easy");
        normal.setActionCommand("normal");
        hard.setActionCommand("hard");

        southPanel.add(newGame);
        southPanel.add(easy);
        southPanel.add(normal);
        southPanel.add(hard);

        southPanel.add(cheatGame);

        southPanel.setBackground(Color.YELLOW);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JButton getCheatButton() {
        return cheatGame;
    }

    public JButton getNewGameButton() {
        return newGame;
    }

    public JRadioButton getEasy() {
        return easy;
    }

    public JRadioButton getNormal() {
        return normal;
    }

    public JRadioButton getHard() {
        return hard;
    }

    public void setMessageLabelText(String text) {
        messageLabel.setText(text);
    }

    public void setMovesCounter(int counter) {
        movesCounter.setText(String.valueOf(counter));
    }
    public void setMovesCounter(String message) {
        movesCounter.setText(message);
    }


    public void updatePanel() {
        centerPanel.removeAll();
        squareGrid.forAll(square -> centerPanel.add(square));
        revalidate();
        repaint();
    }

    public Grid<Square> getSquareGrid() {
        return squareGrid;
    }

}
