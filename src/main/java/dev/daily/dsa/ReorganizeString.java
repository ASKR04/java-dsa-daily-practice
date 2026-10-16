package dev.daily.dsa;

import java.util.Objects;
import java.util.PriorityQueue;

public final class ReorganizeString {
    private static final int ALPHABET_SIZE = 26;

    private ReorganizeString() {
    }

    public static String reorganize(String value) {
        Objects.requireNonNull(value, "value must not be null");

        int[] frequencies = new int[ALPHABET_SIZE];
        for (int index = 0; index < value.length(); index++) {
            char character = value.charAt(index);
            if (character < 'a' || character > 'z') {
                throw new IllegalArgumentException("value must contain only lowercase letters");
            }
            frequencies[character - 'a']++;
        }

        PriorityQueue<Integer> mostFrequentFirst = new PriorityQueue<>((first, second) -> {
            int byFrequency = Integer.compare(frequencies[second], frequencies[first]);
            return byFrequency != 0 ? byFrequency : Integer.compare(first, second);
        });
        for (int character = 0; character < ALPHABET_SIZE; character++) {
            if (frequencies[character] > 0) {
                mostFrequentFirst.offer(character);
            }
        }

        StringBuilder result = new StringBuilder(value.length());
        int previous = -1;

        while (!mostFrequentFirst.isEmpty()) {
            int current = mostFrequentFirst.remove();
            result.append((char) ('a' + current));
            frequencies[current]--;

            if (previous != -1 && frequencies[previous] > 0) {
                mostFrequentFirst.offer(previous);
            }
            previous = current;
        }

        return result.length() == value.length() ? result.toString() : "";
    }
}
