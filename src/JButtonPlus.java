
import javax.swing.*;

public class JButtonPlus extends JButton{
    int index;

    public JButtonPlus(int index, String text) {
        super(text);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
