package models;

public class GridSize {
	private final int columns;

	public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}

	private final int rows;

	public GridSize(int columns, int rows) {
		this.columns = columns;
		this.rows = rows;
	}

	public int getCapacity() {
		return columns*rows;
	}
}
