package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GridTest {

    Grid<Square> grid = new Grid<>(new Square[2][2]);
    Position a = new Position(1, 1);
    Position b = new Position(1, 2);
    Position c = new Position(2, 1);
    Position d = new Position(2, 2);

    List<Position> positions = new ArrayList<>();


    @Test
    void swap() {
        grid.set(a, new Square("1"));
        grid.set(b, new Square("2"));
        grid.set(c, new Square("3"));
        grid.set(d, new Square("4"));
        grid.swap(a, d);
        List<String> list = new ArrayList<>();
        grid.forAll(square -> list.add(square.getText()));

        assert list.get(3).equals("1");
        assert !list.get(0).equals("1");

    }

    @Test
    void getAllPositions() {
        grid.set(a, new Square("1"));
        grid.set(b, new Square("2"));
        grid.set(c, new Square("3"));
        grid.set(d, new Square("4"));

        positions = grid.getAllPositions();

        assert !positions.isEmpty();
        assert positions.size() == 4;
        assert positions.get(0).equals(a);
        assert positions.get(3).equals(d);

    }

    @Test
    void getCol() {
        assert grid.getCols() == 2;
        assert grid.getCols() != 1;
    }

    @Test
    void getRow() {
        assert grid.getRows() == 2;
        assert grid.getRows() != 1;
    }

}