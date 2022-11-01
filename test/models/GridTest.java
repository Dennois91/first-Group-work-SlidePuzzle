package models;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class GridTest {

    Grid<Square> grid = new Grid<>(new Square[2][2]);
    Position a = new Position(1, 1);
    Position b = new Position(1, 2);
    Position c = new Position(2, 1);
    Position d = new Position(2, 2);

    List<Position> positionList = new ArrayList<>();

    @Test
    void findPosition() {
    }

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
    void shuffle() {
        positionList.add(a);
        positionList.add(b);
        positionList.add(c);

        for (int i = 0; i < 200; i++) {
            var currentPositions = positionList;
            var newPositions = new ArrayList<>(currentPositions);

            assert currentPositions.equals(newPositions);

            Collections.shuffle(newPositions);
            if (currentPositions.equals(newPositions)) {
                Collections.shuffle(newPositions);
                continue;
            }
            assert !currentPositions.equals(newPositions);
        }
    }

    @Test
    void getAllPositions() {
    }

    @Test
    void forAll() {
    }
}