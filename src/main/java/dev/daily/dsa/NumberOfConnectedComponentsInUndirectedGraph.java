package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public final class NumberOfConnectedComponentsInUndirectedGraph {
    private NumberOfConnectedComponentsInUndirectedGraph() {
    }

    public static int countComponents(int nodeCount, int[][] edges) {
        if (nodeCount < 0) {
            throw new IllegalArgumentException("node count must be non-negative");
        }
        Objects.requireNonNull(edges, "edges must not be null");

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
        int components = 0;

        for (int start = 0; start < nodeCount; start++) {
            if (visited[start]) {
                continue;
            }

            components++;
            visitComponent(start, adjacency, visited);
        }

        return components;
    }

    private static void visitComponent(
            int start,
            List<List<Integer>> adjacency,
            boolean[] visited) {
        Deque<Integer> stack = new ArrayDeque<>();
        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbor : adjacency.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }

    private static void validateNode(int node, int nodeCount) {
        if (node < 0 || node >= nodeCount) {
            throw new IllegalArgumentException("node index is outside the graph");
        }
    }
}
