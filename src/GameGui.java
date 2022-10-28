
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
    JButton nr1 = new JButtonPlus(1, "2");
    JButton nr2 = new JButtonPlus(2, "2");
    JButton nr3 = new JButtonPlus(3, "3");
    JButton nr4 = new JButtonPlus(4, "4");
    JButton nr5 = new JButtonPlus(5, "5");
    JButton nr6 = new JButtonPlus(6, "6");
    JButton nr7 = new JButtonPlus(7, "7");
    JButton nr8 = new JButtonPlus(8, "8");
    JButton nr9 = new JButtonPlus(9, "9");
    JButton nr10 = new JButtonPlus(10, "10");
    JButton nr11 = new JButtonPlus(11, "11");
    JButton nr12 = new JButtonPlus(12, "12");
    JButton nr13 = new JButtonPlus(13, "13");
    JButton nr14 = new JButtonPlus(14, "14");
    JButton nr15 = new JButtonPlus(15, "15");
    JButton blank = new JButtonPlus(16, " ");
    List<JButton> buttonList;


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

        buttonList = bList();
        Engine engine = Engine.create(bList());

        int temp = 1;
        for (JButton button : buttonList) {
            centerPanel.add(button);
            int finalTemp = temp;
            button.addActionListener((i) -> engine.moveButtonValue(finalTemp));
            temp++;

        }

        southPanel.add(newGame);
        southPanel.add(cheatGame);
        southPanel.setBackground(Color.YELLOW);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    protected List<JButton> bList() {
        List<JButton> buttons = new ArrayList<>();
        buttons.add(nr1);
        buttons.add(nr2);
        buttons.add(nr3);
        buttons.add(nr4);
        buttons.add(nr5);
        buttons.add(nr6);
        buttons.add(nr7);
        buttons.add(nr8);
        buttons.add(nr9);
        buttons.add(nr10);
        buttons.add(nr11);
        buttons.add(nr12);
        buttons.add(nr13);
        buttons.add(nr14);
        buttons.add(nr15);
        buttons.add(blank);
        return buttons;
    }
}
