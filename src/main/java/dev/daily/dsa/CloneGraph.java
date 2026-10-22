package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class CloneGraph {
    private CloneGraph() {
    }

    public static Node cloneGraph(Node start) {
        if (start == null) {
            return null;
        }

        Map<Node, Node> clones = new IdentityHashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        clones.put(start, new Node(start.value));
        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            Node currentClone = clones.get(current);

            for (Node neighbor : current.neighbors) {
                if (neighbor == null) {
                    throw new IllegalArgumentException("neighbors must not contain null");
                }
                if (!clones.containsKey(neighbor)) {
                    clones.put(neighbor, new Node(neighbor.value));
                    queue.add(neighbor);
                }
                currentClone.neighbors.add(clones.get(neighbor));
            }
        }

        return clones.get(start);
    }

    public static final class Node {
        private final int value;
        private final List<Node> neighbors;

        public Node(int value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }

        public int value() {
            return value;
        }

        public List<Node> neighbors() {
            return neighbors;
        }

        public void connect(Node neighbor) {
            if (neighbor == null) {
                throw new IllegalArgumentException("neighbor must not be null");
            }
            neighbors.add(neighbor);
        }
    }
}
