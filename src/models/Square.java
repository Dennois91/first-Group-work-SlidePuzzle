package models;

import javax.swing.*;
import java.awt.*;

public class Square extends JButton {
	private Square(String s) {
		super(s);
	}

	@Override
	public Dimension getPreferredSize() {
		var dimensions = super.getPreferredSize();
		var biggestDimension = (int) (Math.max(dimensions.getWidth(), dimensions.getHeight()));
		return new Dimension(biggestDimension, biggestDimension);
	}
}