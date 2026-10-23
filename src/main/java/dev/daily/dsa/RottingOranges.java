package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public final class RottingOranges {
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    private RottingOranges() {
    }

    public static int minimumMinutes(int[][] grid) {
        Objects.requireNonNull(grid, "grid must not be null");
        int columns = validateAndGetColumnCount(grid);
        if (grid.length == 0 || columns == 0) {
            return 0;
        }

        boolean[][] rotten = new boolean[grid.length][columns];
        Deque<Integer> queue = new ArrayDeque<>();
        int freshOranges = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == 2) {
                    rotten[row][column] = true;
                    queue.add(row * columns + column);
                } else if (grid[row][column] == 1) {
                    freshOranges++;
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty() && freshOranges > 0) {
            int orangesThisMinute = queue.size();
            boolean spread = false;

            for (int index = 0; index < orangesThisMinute; index++) {
                int cell = queue.remove();
                int row = cell / columns;
                int column = cell % columns;

                for (int[] direction : DIRECTIONS) {
                    int nextRow = row + direction[0];
                    int nextColumn = column + direction[1];
                    if (nextRow >= 0
                            && nextRow < grid.length
                            && nextColumn >= 0
                            && nextColumn < columns
                            && grid[nextRow][nextColumn] == 1
                            && !rotten[nextRow][nextColumn]) {
                        rotten[nextRow][nextColumn] = true;
                        freshOranges--;
                        spread = true;
                        queue.add(nextRow * columns + nextColumn);
                    }
                }
            }

            if (spread) {
                minutes++;
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }

    private static int validateAndGetColumnCount(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        if (grid[0] == null) {
            throw new IllegalArgumentException("grid rows must not be null");
        }

        int columns = grid[0].length;
        for (int[] row : grid) {
            if (row == null || row.length != columns) {
                throw new IllegalArgumentException("grid must be rectangular");
            }
            for (int cell : row) {
                if (cell < 0 || cell > 2) {
                    throw new IllegalArgumentException("grid cells must be 0, 1, or 2");
                }
            }
        }
        return columns;
    }
}
