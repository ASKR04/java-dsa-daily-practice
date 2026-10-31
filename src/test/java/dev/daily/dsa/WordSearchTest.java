package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WordSearchTest {
    @Test
    void findsWordsAlongDifferentPaths() {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        assertTrue(WordSearch.exists(board, "ABCCED"));
        assertTrue(WordSearch.exists(board, "SEE"));
    }

    @Test
    void rejectsWordThatWouldReuseACell() {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        assertFalse(WordSearch.exists(board, "ABCB"));
        assertFalse(WordSearch.exists(new char[][] {{'A'}}, "AA"));
    }

    @Test
    void handlesEmptyWordAndBoard() {
        assertTrue(WordSearch.exists(new char[0][], ""));
        assertFalse(WordSearch.exists(new char[0][], "A"));
    }

    @Test
    void doesNotModifyBoard() {
        char[][] board = {{'A', 'B'}, {'C', 'D'}};
        char[][] original = {board[0].clone(), board[1].clone()};

        WordSearch.exists(board, "ABD");

        assertArrayEquals(original[0], board[0]);
        assertArrayEquals(original[1], board[1]);
    }

    @Test
    void rejectsNullInputs() {
        assertThrows(
                NullPointerException.class,
                () -> WordSearch.exists(null, "A"));
        assertThrows(
                NullPointerException.class,
                () -> WordSearch.exists(new char[][] {{'A'}}, null));
    }

    @Test
    void rejectsJaggedBoard() {
        assertThrows(
                IllegalArgumentException.class,
                () -> WordSearch.exists(
                        new char[][] {{'A', 'B'}, {'C'}},
                        "ABC"));
    }
}
