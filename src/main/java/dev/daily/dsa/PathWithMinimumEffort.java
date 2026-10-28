package dev.daily.dsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public final class PathWithMinimumEffort {
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    private PathWithMinimumEffort() {
    }

    public static int minimumEffort(int[][] heights) {
        Objects.requireNonNull(heights, "heights must not be null");
        int columns = validateAndGetColumnCount(heights);
        if (heights.length == 0 || columns == 0) {
            return 0;
        }

        long[][] efforts = new long[heights.length][columns];
        for (long[] row : efforts) {
            Arrays.fill(row, Long.MAX_VALUE);
        }
        efforts[0][0] = 0;

        PriorityQueue<State> queue = new PriorityQueue<>(
                Comparator.comparingLong(State::effort));
        queue.add(new State(0, 0, 0));

        while (!queue.isEmpty()) {
            State current = queue.remove();
            if (current.effort() != efforts[current.row()][current.column()]) {
                continue;
            }
            if (current.row() == heights.length - 1
                    && current.column() == columns - 1) {
                return Math.toIntExact(current.effort());
            }

            for (int[] direction : DIRECTIONS) {
                int nextRow = current.row() + direction[0];
                int nextColumn = current.column() + direction[1];
                if (nextRow < 0
                        || nextRow >= heights.length
                        || nextColumn < 0
                        || nextColumn >= columns) {
                    continue;
                }

                long stepEffort = Math.abs(
                        (long) heights[current.row()][current.column()]
                                - heights[nextRow][nextColumn]);
                long routeEffort = Math.max(current.effort(), stepEffort);
                if (routeEffort < efforts[nextRow][nextColumn]) {
                    efforts[nextRow][nextColumn] = routeEffort;
                    queue.add(new State(nextRow, nextColumn, routeEffort));
                }
            }
        }

        throw new IllegalStateException("destination must be reachable");
    }

    private static int validateAndGetColumnCount(int[][] heights) {
        if (heights.length == 0) {
            return 0;
        }
        if (heights[0] == null) {
            throw new IllegalArgumentException("height rows must not be null");
        }

        int columns = heights[0].length;
        for (int[] row : heights) {
            if (row == null || row.length != columns) {
                throw new IllegalArgumentException("heights must be rectangular");
            }
        }
        return columns;
    }

    private record State(int row, int column, long effort) {
    }
}
