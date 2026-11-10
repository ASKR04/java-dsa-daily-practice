package dev.daily.dsa;

import java.util.Objects;

/** Finds the length of the longest subsequence shared by two strings. */
public final class LongestCommonSubsequence {
    private LongestCommonSubsequence() {
    }

    public static int length(String first, String second) {
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

        for (int row = 1; row <= rows.length(); row++) {
            for (int column = 1; column <= columns.length(); column++) {
                if (rows.charAt(row - 1) == columns.charAt(column - 1)) {
                    current[column] = previous[column - 1] + 1;
                } else {
                    current[column] = Math.max(
                            previous[column], current[column - 1]);
                }
            }

            int[] swap = previous;
            previous = current;
            current = swap;
        }

        return previous[columns.length()];
    }
}
