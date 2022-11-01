package models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListen extends MouseAdapter {

    JButton button;

    public MouseListen(JButton button) {
        this.button = button;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.setBackground(Color.green);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        button.setBackground(new JButton().getBackground());
    }
}
