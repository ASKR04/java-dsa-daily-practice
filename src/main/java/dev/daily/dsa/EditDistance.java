package dev.daily.dsa;

import java.util.Objects;

/** Computes the minimum number of edits needed to transform one string. */
public final class EditDistance {
    private EditDistance() {
    }

    public static int distance(String first, String second) {
        Objects.requireNonNull(first, "first must not be null");
        Objects.requireNonNull(second, "second must not be null");

        String rows = first;
        String columns = second;
        if (columns.length() > rows.length()) {
            rows = second;
            columns = first;
        }

        int[] previous = new int[columns.length() + 1];
        int[] current = new int[columns.length() + 1];
        for (int column = 0; column <= columns.length(); column++) {
            previous[column] = column;
        }

        for (int row = 1; row <= rows.length(); row++) {
            current[0] = row;
            for (int column = 1; column <= columns.length(); column++) {
                if (rows.charAt(row - 1) == columns.charAt(column - 1)) {
                    current[column] = previous[column - 1];
                } else {
                    int insert = current[column - 1];
                    int delete = previous[column];
                    int replace = previous[column - 1];
                    current[column] = 1 + Math.min(
                            replace, Math.min(insert, delete));
                }
            }

            int[] swap = previous;
            previous = current;
            current = swap;
        }

        return previous[columns.length()];
    }
}
