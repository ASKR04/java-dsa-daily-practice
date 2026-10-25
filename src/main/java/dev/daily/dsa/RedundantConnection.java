package dev.daily.dsa;

import java.util.Objects;

public final class RedundantConnection {
    private RedundantConnection() {
    }

    public static int[] findRedundantEdge(int[][] edges) {
        Objects.requireNonNull(edges, "edges must not be null");
        int largestVertex = 0;
        for (int[] edge : edges) {
            validateEdge(edge);
            largestVertex = Math.max(largestVertex, Math.max(edge[0], edge[1]));
        }

        DisjointSet disjointSet = new DisjointSet(largestVertex + 1);

        for (int[] edge : edges) {
            if (!disjointSet.union(edge[0], edge[1])) {
                return edge.clone();
            }
        }

        return new int[0];
    }

    private static void validateEdge(int[] edge) {
        if (edge == null || edge.length != 2) {
            throw new IllegalArgumentException("each edge must contain two vertices");
        }
        if (edge[0] < 1 || edge[1] < 1) {
            throw new IllegalArgumentException("vertex labels must be positive");
        }
    }

    private static final class DisjointSet {
        private final int[] parent;
        private final int[] size;

        private DisjointSet(int elementCount) {
            parent = new int[elementCount];
            size = new int[elementCount];
            for (int element = 0; element < elementCount; element++) {
                parent[element] = element;
                size[element] = 1;
            }
        }

        private int find(int element) {
            int root = element;
            while (root != parent[root]) {
                root = parent[root];
            }

            while (element != root) {
                int next = parent[element];
                parent[element] = root;
                element = next;
            }
            return root;
        }

        private boolean union(int first, int second) {
            int firstRoot = find(first);
            int secondRoot = find(second);
            if (firstRoot == secondRoot) {
                return false;
            }

            if (size[firstRoot] < size[secondRoot]) {
                int temporary = firstRoot;
                firstRoot = secondRoot;
                secondRoot = temporary;
            }

            parent[secondRoot] = firstRoot;
            size[firstRoot] += size[secondRoot];
            return true;
        }
    }
}
