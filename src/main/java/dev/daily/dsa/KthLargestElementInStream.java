package dev.daily.dsa;

import java.util.Objects;
import java.util.PriorityQueue;

public final class KthLargestElementInStream {
    private final int k;
    private final PriorityQueue<Integer> largestValues = new PriorityQueue<>();

    public KthLargestElementInStream(int k, int[] initialValues) {
        if (k < 1) {
            throw new IllegalArgumentException("k must be positive");
        }
        Objects.requireNonNull(initialValues, "initial values must not be null");
        if (initialValues.length < k - 1) {
            throw new IllegalArgumentException(
                    "the first added value must make at least k values available");
        }

        this.k = k;
        for (int value : initialValues) {
            offer(value);
        }
    }

    public int add(int value) {
        offer(value);
        return largestValues.element();
    }

    private void offer(int value) {
        if (largestValues.size() < k) {
            largestValues.offer(value);
        } else if (value > largestValues.element()) {
            largestValues.remove();
            largestValues.offer(value);
        }
    }
}
