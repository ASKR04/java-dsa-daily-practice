package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class KthLargestElementInStreamTest {
    @Test
    void tracksKthLargestAcrossAdditions() {
        KthLargestElementInStream stream =
                new KthLargestElementInStream(3, new int[] {4, 5, 8, 2});

        assertEquals(4, stream.add(3));
        assertEquals(5, stream.add(5));
        assertEquals(5, stream.add(10));
        assertEquals(8, stream.add(9));
        assertEquals(8, stream.add(4));
    }

    @Test
    void supportsDuplicateValues() {
        KthLargestElementInStream stream =
                new KthLargestElementInStream(2, new int[] {5, 5});

        assertEquals(5, stream.add(5));
        assertEquals(5, stream.add(6));
        assertEquals(6, stream.add(7));
    }

    @Test
    void supportsNegativeValues() {
        KthLargestElementInStream stream =
                new KthLargestElementInStream(2, new int[] {-3, -2});

        assertEquals(-3, stream.add(-4));
        assertEquals(-2, stream.add(0));
    }

    @Test
    void handlesKEqualToOne() {
        KthLargestElementInStream stream =
                new KthLargestElementInStream(1, new int[0]);

        assertEquals(3, stream.add(3));
        assertEquals(7, stream.add(7));
        assertEquals(7, stream.add(2));
    }

    @Test
    void doesNotModifyInitialArray() {
        int[] initial = {4, 2, 9};
        int[] original = initial.clone();

        new KthLargestElementInStream(2, initial);

        assertArrayEquals(original, initial);
    }

    @Test
    void rejectsNonPositiveK() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new KthLargestElementInStream(0, new int[0]));
    }

    @Test
    void rejectsTooFewValuesForFirstAddition() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new KthLargestElementInStream(3, new int[] {4}));
    }
}
