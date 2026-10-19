package dev.daily.dsa;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public final class MedianFinder {
    private final PriorityQueue<Integer> lowerHalf =
            new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> upperHalf = new PriorityQueue<>();

    public void add(int value) {
        if (lowerHalf.isEmpty() || value <= lowerHalf.element()) {
            lowerHalf.offer(value);
        } else {
            upperHalf.offer(value);
        }

        if (lowerHalf.size() > upperHalf.size() + 1) {
            upperHalf.offer(lowerHalf.remove());
        } else if (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.offer(upperHalf.remove());
        }
    }

    public double median() {
        if (lowerHalf.isEmpty()) {
            throw new NoSuchElementException("median is undefined for an empty stream");
        }

        if (lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.element();
        }

        long middleSum = (long) lowerHalf.element() + upperHalf.element();
        return middleSum / 2.0;
    }
}
