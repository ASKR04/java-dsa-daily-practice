package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NumberOfConnectedComponentsInUndirectedGraphTest {
    @Test
    void countsMultipleComponents() {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        assertEquals(
                2,
                NumberOfConnectedComponentsInUndirectedGraph.countComponents(5, edges));
    }

    @Test
    void countsEveryIsolatedNode() {
        assertEquals(
                5,
                NumberOfConnectedComponentsInUndirectedGraph.countComponents(
                        5, new int[0][]));
    }

    @Test
    void returnsOneForConnectedGraph() {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};

        assertEquals(
                1,
                NumberOfConnectedComponentsInUndirectedGraph.countComponents(5, edges));
    }

    @Test
    void handlesCyclesAcrossSeparateComponents() {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}, {4, 5}, {5, 3}};

        assertEquals(
                2,
                NumberOfConnectedComponentsInUndirectedGraph.countComponents(6, edges));
    }

    @Test
    void returnsZeroForEmptyGraph() {
        assertEquals(
                0,
                NumberOfConnectedComponentsInUndirectedGraph.countComponents(
                        0, new int[0][]));
    }

    @Test
    void rejectsEndpointOutsideGraph() {
        assertThrows(
                IllegalArgumentException.class,
                () -> NumberOfConnectedComponentsInUndirectedGraph.countComponents(
                        3, new int[][] {{0, 3}}));
    }

    @Test
    void rejectsMalformedEdge() {
        assertThrows(
                IllegalArgumentException.class,
                () -> NumberOfConnectedComponentsInUndirectedGraph.countComponents(
                        3, new int[][] {{0}}));
    }
}
