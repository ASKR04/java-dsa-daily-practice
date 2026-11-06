package dev.daily.dsa;

import java.util.Arrays;

public final class UniquePaths {
    private UniquePaths() {
    }

    public static long count(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException(
                    "rows and columns must be positive");
        }

        int smallerDimension = Math.min(rows, columns);
        int largerDimension = Math.max(rows, columns);
        long[] paths = new long[smallerDimension];
        Arrays.fill(paths, 1);

        for (int row = 1; row < largerDimension; row++) {
            for (int column = 1;
                    column < smallerDimension;
                    column++) {
                paths[column] = Math.addExact(
                        paths[column],
                        paths[column - 1]);
            }
        }
        return paths[smallerDimension - 1];
    }
}
