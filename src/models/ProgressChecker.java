package models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProgressChecker {
    private final Grid<Square> grid;

    public ProgressChecker(Grid<Square> grid) {
        this.grid = grid;
    }

    public boolean checkProgress() {
        return squaresAreInOrder();
    }

    private boolean squaresAreInOrder() {
        var positions = grid.getAllPositions();
        AtomicInteger counter = new AtomicInteger(1);
        return positions.stream()
                .limit(positions.size() - 1)
                .map(grid::get)
                .allMatch(square -> Integer.parseInt(square.getText().equals("")
                        ? "0" : square.getText()) == counter.getAndIncrement());
    }







    // test solver

    public boolean isSolvable(int gameSize) {
        List<String> values = new ArrayList<>();
        grid.forAll(square -> values.add(square.getText()));
        System.out.println(values);
        List<Integer> intValues = new ArrayList<>();
        for (String s : values) {
            if (!s.isBlank())
                intValues.add(Integer.parseInt(s));
        }
        System.out.println(intValues);
        int inv_count = 0;
        for (int i = 0; i < gameSize - 1; i++)
            for (int j = i + 1; j < gameSize; j++)
                if (intValues.get(i) > intValues.get(j))
                    inv_count++;
        System.out.println(inv_count);
        values.clear();
        intValues.clear();
        return inv_count % 2 == 0;


    }
}
