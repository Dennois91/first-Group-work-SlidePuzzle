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
    JRadioButton easy = new JRadioButton("Easy");
    JRadioButton normal = new JRadioButton("Normal");
    JRadioButton hard = new JRadioButton("Hard");
    ButtonGroup levels = new ButtonGroup();

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

        squareGrid.forAll(square -> centerPanel.add(square));

        levels.add(easy);
        levels.add(normal);
        levels.add(hard);

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

    public JButton getCheatButton(){
        return cheatGame;
    }
    public JButton getNewGameButton(){
        return newGame;
    }

    public JRadioButton getEasy() {
        return easy;
    }
    public JRadioButton getNormal(){
        return normal;
    }
    public JRadioButton getHard(){
        return hard;
    }

    public void setEasy(JRadioButton easy) {
        this.easy = easy;
    }

    public void setNormal(JRadioButton normal) {
        this.normal = normal;
    }

    public void setHard(JRadioButton hard) {
        this.hard = hard;
    }

    public void updatePanel (){
     centerPanel.removeAll();
     squareGrid.forAll(square -> centerPanel.add(square));
     revalidate();
     repaint();
    }

    public Grid<Square> getSquareGrid() {
        return squareGrid;
    }


}
