package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public final class NumberOfIslands {
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    private NumberOfIslands() {
    }

    public static int countIslands(char[][] grid) {
        Objects.requireNonNull(grid, "grid must not be null");
        int columns = validateAndGetColumnCount(grid);
        if (grid.length == 0 || columns == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][columns];
        int islands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == '1' && !visited[row][column]) {
                    islands++;
                    visitIsland(grid, row, column, visited);
                }
            }
        }

        return islands;
    }

    private static void visitIsland(
            char[][] grid,
            int startRow,
            int startColumn,
            boolean[][] visited) {
        int columns = grid[0].length;
        Deque<Integer> stack = new ArrayDeque<>();
        visited[startRow][startColumn] = true;
        stack.push(startRow * columns + startColumn);

        while (!stack.isEmpty()) {
            int cell = stack.pop();
            int row = cell / columns;
            int column = cell % columns;

            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0];
                int nextColumn = column + direction[1];
                if (nextRow >= 0
                        && nextRow < grid.length
                        && nextColumn >= 0
                        && nextColumn < columns
                        && grid[nextRow][nextColumn] == '1'
                        && !visited[nextRow][nextColumn]) {
                    visited[nextRow][nextColumn] = true;
                    stack.push(nextRow * columns + nextColumn);
                }
            }
        }
    }

    private static int validateAndGetColumnCount(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        if (grid[0] == null) {
            throw new IllegalArgumentException("grid rows must not be null");
        }
        int columns = grid[0].length;

        for (char[] row : grid) {
            if (row == null || row.length != columns) {
                throw new IllegalArgumentException("grid must be rectangular");
            }
            for (char cell : row) {
                if (cell != '0' && cell != '1') {
                    throw new IllegalArgumentException("grid cells must be '0' or '1'");
                }
            }
        }
        return columns;
    }
}
