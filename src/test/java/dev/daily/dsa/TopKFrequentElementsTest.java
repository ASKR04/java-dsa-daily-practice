package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TopKFrequentElementsTest {
    @Test
    void returnsMostFrequentValues() {
        assertArrayEquals(
                new int[] {1, 2},
                TopKFrequentElements.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2));
    }

    @Test
    void handlesSingleDistinctValue() {
        assertArrayEquals(
                new int[] {7},
                TopKFrequentElements.topKFrequent(new int[] {7, 7, 7}, 1));
    }

    @Test
    void supportsNegativeValues() {
        assertArrayEquals(
                new int[] {2, -1},
                TopKFrequentElements.topKFrequent(new int[] {-1, -1, 2, 2, 2, 3}, 2));
    }

    @Test
    void ordersFrequencyTiesBySmallerValue() {
        assertArrayEquals(
                new int[] {1, 2},
                TopKFrequentElements.topKFrequent(new int[] {4, 1, 3, 2}, 2));
    }

    @Test
    void doesNotModifyInputArray() {
        int[] values = {2, 1, 2, 3};
        int[] original = values.clone();

        TopKFrequentElements.topKFrequent(values, 2);

        assertArrayEquals(original, values);
    }

    @Test
    void rejectsNonPositiveK() {
        assertThrows(
                IllegalArgumentException.class,
                () -> TopKFrequentElements.topKFrequent(new int[] {1}, 0));
    }

    @Test
    void rejectsKGreaterThanDistinctValueCount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> TopKFrequentElements.topKFrequent(new int[] {1, 1, 2}, 3));
    }
}
