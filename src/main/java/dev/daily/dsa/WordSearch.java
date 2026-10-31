package dev.daily.dsa;

import java.util.Objects;

public final class WordSearch {
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    private WordSearch() {
    }

    public static boolean exists(char[][] board, String word) {
        Objects.requireNonNull(board, "board must not be null");
        Objects.requireNonNull(word, "word must not be null");
        int columns = validateAndGetColumnCount(board);
        if (word.isEmpty()) {
            return true;
        }
        if (board.length == 0 || columns == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][columns];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < columns; column++) {
                if (search(board, word, row, column, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search(
            char[][] board,
            String word,
            int row,
            int column,
            int index,
            boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0
                || row >= board.length
                || column < 0
                || column >= board[0].length
                || visited[row][column]
                || board[row][column] != word.charAt(index)) {
            return false;
        }

        visited[row][column] = true;
        boolean found = false;
        for (int[] direction : DIRECTIONS) {
            if (search(
                    board,
                    word,
                    row + direction[0],
                    column + direction[1],
                    index + 1,
                    visited)) {
                found = true;
                break;
            }
        }
        visited[row][column] = false;
        return found;
    }

    private static int validateAndGetColumnCount(char[][] board) {
        if (board.length == 0) {
            return 0;
        }
        if (board[0] == null) {
            throw new IllegalArgumentException("board rows must not be null");
        }

        int columns = board[0].length;
        for (char[] row : board) {
            if (row == null || row.length != columns) {
                throw new IllegalArgumentException("board must be rectangular");
            }
        }
        return columns;
    }
}
