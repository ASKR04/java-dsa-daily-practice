package dev.daily.dsa;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public final class LastStoneWeight {
    private LastStoneWeight() {
    }

    public static int lastStoneWeight(int[] stones) {
        Objects.requireNonNull(stones, "stones must not be null");

        PriorityQueue<Integer> heaviestFirst =
                new PriorityQueue<>(Comparator.reverseOrder());
        for (int weight : stones) {
            if (weight < 0) {
                throw new IllegalArgumentException("stone weights must be non-negative");
            }
            if (weight > 0) {
                heaviestFirst.offer(weight);
            }
        }

        while (heaviestFirst.size() > 1) {
            int heaviest = heaviestFirst.remove();
            int secondHeaviest = heaviestFirst.remove();
            if (heaviest != secondHeaviest) {
                heaviestFirst.offer(heaviest - secondHeaviest);
            }
        }

        return heaviestFirst.isEmpty() ? 0 : heaviestFirst.remove();
    }
}
