package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchA2DMatrixTest {
    @Test
    void findsTargetInsideMatrix() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        assertTrue(SearchA2DMatrix.searchMatrix(matrix, 3));
    }

    @Test
    void returnsFalseWhenTargetIsMissing() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        assertFalse(SearchA2DMatrix.searchMatrix(matrix, 13));
    }

    @Test
    void findsTargetAtFirstPosition() {
        int[][] matrix = {
                {1, 2},
                {4, 5}
        };

        assertTrue(SearchA2DMatrix.searchMatrix(matrix, 1));
    }

    @Test
    void findsTargetAtLastPosition() {
        int[][] matrix = {
                {1, 2},
                {4, 5}
        };

        assertTrue(SearchA2DMatrix.searchMatrix(matrix, 5));
    }

    @Test
    void handlesSingleCellMatrix() {
        int[][] matrix = {{8}};

        assertTrue(SearchA2DMatrix.searchMatrix(matrix, 8));
        assertFalse(SearchA2DMatrix.searchMatrix(matrix, 9));
    }
}
