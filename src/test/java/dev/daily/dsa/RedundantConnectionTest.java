package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RedundantConnectionTest {
    @Test
    void findsEdgeThatCompletesTriangle() {
        int[][] edges = {
            {1, 2},
            {1, 3},
            {2, 3}
        };

        assertArrayEquals(
                new int[] {2, 3},
                RedundantConnection.findRedundantEdge(edges));
    }

    @Test
    void findsRedundantEdgeAfterSeveralUnions() {
        int[][] edges = {
            {1, 2},
            {2, 3},
            {3, 4},
            {1, 4},
            {1, 5}
        };

        assertArrayEquals(
                new int[] {1, 4},
                RedundantConnection.findRedundantEdge(edges));
    }

    @Test
    void handlesEdgeConnectingVerticesAlreadyLinkedIndirectly() {
        int[][] edges = {
            {1, 2},
            {3, 4},
            {2, 3},
            {1, 4}
        };

        assertArrayEquals(
                new int[] {1, 4},
                RedundantConnection.findRedundantEdge(edges));
    }

    @Test
    void returnsEmptyArrayWhenNoCycleExists() {
        assertArrayEquals(
                new int[0],
                RedundantConnection.findRedundantEdge(
                        new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }

    @Test
    void doesNotModifyInputEdges() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[][] original = {edges[0].clone(), edges[1].clone(), edges[2].clone()};

        RedundantConnection.findRedundantEdge(edges);

        assertArrayEquals(original[0], edges[0]);
        assertArrayEquals(original[1], edges[1]);
        assertArrayEquals(original[2], edges[2]);
    }

    @Test
    void rejectsMalformedEdge() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RedundantConnection.findRedundantEdge(new int[][] {{1}}));
    }

    @Test
    void rejectsNonPositiveVertex() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RedundantConnection.findRedundantEdge(
                        new int[][] {{1, 2}, {2, 0}, {1, 3}}));
    }
}
