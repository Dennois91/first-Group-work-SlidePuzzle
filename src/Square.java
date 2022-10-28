import javax.swing.*;

public class Square extends JButton {
	private Position currentPosition;

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	private final Position homePosition;

	public Position getHomePosition() {
		return homePosition;
	}

	public Square(Position currentPosition, Position homePosition) {
		this.currentPosition = currentPosition;
		this.homePosition = homePosition;
	}


}
