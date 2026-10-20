package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public final class FindIfPathExistsInGraph {
    private FindIfPathExistsInGraph() {
    }

    public static boolean hasPath(int nodeCount, int[][] edges, int source, int destination) {
        if (nodeCount < 1) {
            throw new IllegalArgumentException("node count must be positive");
        }
        Objects.requireNonNull(edges, "edges must not be null");
        validateNode(source, nodeCount);
        validateNode(destination, nodeCount);

        List<List<Integer>> adjacency = new ArrayList<>(nodeCount);
        for (int node = 0; node < nodeCount; node++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            if (edge == null || edge.length != 2) {
                throw new IllegalArgumentException("each edge must contain two endpoints");
            }
            validateNode(edge[0], nodeCount);
            validateNode(edge[1], nodeCount);
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[nodeCount];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (node == destination) {
                return true;
            }

            for (int neighbor : adjacency.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }

    private static void validateNode(int node, int nodeCount) {
        if (node < 0 || node >= nodeCount) {
            throw new IllegalArgumentException("node index is outside the graph");
        }
    }
}
