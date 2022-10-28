import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
    List<JButton> buttonList = new ArrayList<>();


    //Manipulate game buttons
    JButton newGame = new JButton("New game");
    JButton cheatGame = new JButton("Ima cheater!");

    //Game labels
    JLabel movesCounter = new JLabel(String.valueOf(0));
    JLabel messageLabel = new JLabel("Nr of moves: ");

    public GameGui() {

        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        northPanel.add(messageLabel);
        northPanel.add(movesCounter);
        northPanel.setBackground(Color.YELLOW);

        centerPanel.setLayout(new GridLayout(4, 4));

        buttonList.add(nr1);
        buttonList.add(nr2);
        buttonList.add(nr3);
        buttonList.add(nr4);
        buttonList.add(nr5);
        buttonList.add(nr6);
        buttonList.add(nr7);
        buttonList.add(nr8);
        buttonList.add(nr9);
        buttonList.add(nr10);
        buttonList.add(nr11);
        buttonList.add(nr12);
        buttonList.add(nr13);
        buttonList.add(nr14);
        buttonList.add(nr15);
        buttonList.add(blank);

        for (JButton button : buttonList) {
            centerPanel.add(button);
            button.addActionListener((i) -> engine.moveButtonValue(i));
        }

        southPanel.add(newGame);
        southPanel.add(cheatGame);
        southPanel.setBackground(Color.YELLOW);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
