package models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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

	public Square switchSquareData(Square b) {
		switchSquarePositions(this,b);
		switchSquareTexts(this,b);
		return this;
	}

	private void switchSquarePositions(Square a, Square b) {
		var tempPositionHolder = a.getCurrentPosition();
		a.setCurrentPosition(b.getCurrentPosition());
		b.setCurrentPosition(tempPositionHolder);
	}

	private void switchSquareTexts(Square a, Square b) {
		var tempTextHolder = a.getText();
		a.setText(b.getText());
		b.setText(tempTextHolder);
	}

	public boolean canMove(Square emptySquare) {
		var squaresThatCanMove = getAdjacentPositions(emptySquare.getCurrentPosition());
		return squaresThatCanMove.contains(currentPosition);
	}

	private List<Position> getAdjacentPositions(Position positionOfEmptyValue) {
		List<Position> adjacentPositions = new ArrayList<>();
		adjacentPositions.add(positionOfEmptyValue.up());
		adjacentPositions.add(positionOfEmptyValue.down());
		adjacentPositions.add(positionOfEmptyValue.left());
		adjacentPositions.add(positionOfEmptyValue.right());
		return adjacentPositions;
	}
}
