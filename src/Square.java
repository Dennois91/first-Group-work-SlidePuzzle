import javax.swing.*;

public class Square extends JButton {
	private Position current;

	public Position getCurrent() {
		return current;
	}

	public void setCurrent(Position current) {
		this.current = current;
	}

	private final Position home;

	public Position getHome() {
		return home;
	}

	public Square(Position current, Position home) {
		this.current = current;
		this.home = home;
	}


}
