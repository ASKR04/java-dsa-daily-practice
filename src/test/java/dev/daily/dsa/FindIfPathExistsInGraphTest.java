package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FindIfPathExistsInGraphTest {
    @Test
    void findsPathThroughConnectedGraph() {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};

        assertTrue(FindIfPathExistsInGraph.hasPath(3, edges, 0, 2));
    }

    @Test
    void returnsFalseForDifferentComponents() {
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};

        assertFalse(FindIfPathExistsInGraph.hasPath(6, edges, 0, 5));
    }

    @Test
    void findsIndirectPathThroughCycle() {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 1}, {3, 4}};

        assertTrue(FindIfPathExistsInGraph.hasPath(5, edges, 0, 4));
    }

    @Test
    void sourceAlwaysReachesItself() {
        assertTrue(FindIfPathExistsInGraph.hasPath(4, new int[0][], 2, 2));
    }

    @Test
    void handlesSingleNodeGraph() {
        assertTrue(FindIfPathExistsInGraph.hasPath(1, new int[0][], 0, 0));
    }

    @Test
    void rejectsEndpointOutsideGraph() {
        assertThrows(
                IllegalArgumentException.class,
                () -> FindIfPathExistsInGraph.hasPath(3, new int[][] {{0, 3}}, 0, 2));
    }

    @Test
    void rejectsMalformedEdge() {
        assertThrows(
                IllegalArgumentException.class,
                () -> FindIfPathExistsInGraph.hasPath(3, new int[][] {{0}}, 0, 2));
    }
}
