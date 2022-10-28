import javax.swing.*;
import java.awt.*;

public class GameGui extends JFrame {


    //Panel layouts
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();

    //Game Buttons
    JButton nr1 = new JButton("1");
    JButton nr2 = new JButton("2");
    JButton nr3 = new JButton("3");
    JButton nr4 = new JButton("4");
    JButton nr5 = new JButton("5");
    JButton nr6 = new JButton("6");
    JButton nr7 = new JButton("7");
    JButton nr8 = new JButton("8");
    JButton nr9 = new JButton("9");
    JButton nr10 = new JButton("10");
    JButton nr11 = new JButton("11");
    JButton nr12 = new JButton("12");
    JButton nr13 = new JButton("13");
    JButton nr14 = new JButton("14");
    JButton nr15 = new JButton("15");
    JButton blank = new JButton(" ");

    //Manipulate game buttons
    JButton newGame = new JButton("New game");
    JButton cheatGame = new JButton("Ima cheater!");

    //Game labels
    JLabel movesCounter = new JLabel(String.valueOf(0));

    public GameGui() throws HeadlessException {

        setLayout(new BorderLayout());
        add(northPanel,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);
        add(southPanel,BorderLayout.SOUTH);

        northPanel.add(movesCounter);

        centerPanel.setLayout(new GridLayout(4,4));
        centerPanel.add(nr1);
        centerPanel.add(nr2);
        centerPanel.add(nr3);
        centerPanel.add(nr4);
        centerPanel.add(nr5);
        centerPanel.add(nr6);
        centerPanel.add(nr7);
        centerPanel.add(nr8);
        centerPanel.add(nr9);
        centerPanel.add(nr10);
        centerPanel.add(nr11);
        centerPanel.add(nr12);
        centerPanel.add(nr13);
        centerPanel.add(nr14);
        centerPanel.add(nr15);
        centerPanel.add(blank);

        southPanel.add(newGame);
        southPanel.add(cheatGame);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
