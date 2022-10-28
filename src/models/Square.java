package models;

import javax.swing.*;

public class Square extends JButton {
	private final Position homePosition;
	private Position currentPosition;

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Square(Position currentPosition, Position homePosition) {
		this.currentPosition = currentPosition;
		this.homePosition = homePosition;
	}

	public boolean isHome() {
		return currentPosition.equals(homePosition);
	}
}
