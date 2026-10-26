package dev.daily.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public final class NetworkDelayTime {
    private NetworkDelayTime() {
    }

    public static int minimumDelay(int nodeCount, int[][] times, int source) {
        if (nodeCount <= 0) {
            throw new IllegalArgumentException("nodeCount must be positive");
        }
        if (source < 1 || source > nodeCount) {
            throw new IllegalArgumentException("source must be a valid node label");
        }
        Objects.requireNonNull(times, "times must not be null");

        List<List<Edge>> graph = new ArrayList<>(nodeCount + 1);
        for (int node = 0; node <= nodeCount; node++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            validateTime(time, nodeCount);
            graph.get(time[0]).add(new Edge(time[1], time[2]));
        }

        long[] distances = new long[nodeCount + 1];
        Arrays.fill(distances, Long.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<State> queue = new PriorityQueue<>(
                Comparator.comparingLong(State::distance));
        queue.add(new State(source, 0));

        while (!queue.isEmpty()) {
            State current = queue.remove();
            if (current.distance() != distances[current.node()]) {
                continue;
            }

            for (Edge edge : graph.get(current.node())) {
                long candidate = current.distance() + edge.travelTime();
                if (candidate < distances[edge.destination()]) {
                    distances[edge.destination()] = candidate;
                    queue.add(new State(edge.destination(), candidate));
                }
            }
        }

        long maximumDelay = 0;
        for (int node = 1; node <= nodeCount; node++) {
            if (distances[node] == Long.MAX_VALUE) {
                return -1;
            }
            maximumDelay = Math.max(maximumDelay, distances[node]);
        }
        return Math.toIntExact(maximumDelay);
    }

    private static void validateTime(int[] time, int nodeCount) {
        if (time == null || time.length != 3) {
            throw new IllegalArgumentException(
                    "each time must contain source, destination, and travel time");
        }
        if (time[0] < 1
                || time[0] > nodeCount
                || time[1] < 1
                || time[1] > nodeCount) {
            throw new IllegalArgumentException("edge endpoint is out of range");
        }
        if (time[2] < 0) {
            throw new IllegalArgumentException("travel time must not be negative");
        }
    }

    private record Edge(int destination, int travelTime) {
    }

    private record State(int node, long distance) {
    }
}
