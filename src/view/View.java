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
    JButton cheatGame = new JButton("Ima cheater!");

    //main.Game labels
    JLabel movesCounter = new JLabel(String.valueOf(0));
    JLabel messageLabel = new JLabel("Nr of moves: ");

    public View(Grid<Square> squareGrid) {

        this.squareGrid = squareGrid;

        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        northPanel.add(messageLabel);
        northPanel.add(movesCounter);
        northPanel.setBackground(Color.YELLOW);

        centerPanel.setLayout(new GridLayout(squareGrid.getRow(), squareGrid.getCol()));
        System.out.println(squareGrid.getRow());
        System.out.println(squareGrid.getCol());

        squareGrid.forAll(square -> centerPanel.add(square));

        southPanel.add(newGame);
        southPanel.add(cheatGame);
        southPanel.setBackground(Color.YELLOW);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public Grid<Square> getSquareGrid() {
        return squareGrid;
    }
}
