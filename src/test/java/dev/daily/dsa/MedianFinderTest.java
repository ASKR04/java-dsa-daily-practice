package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class MedianFinderTest {
    @Test
    void tracksMedianAfterEachAddition() {
        MedianFinder finder = new MedianFinder();

        finder.add(1);
        assertEquals(1.0, finder.median());
        finder.add(2);
        assertEquals(1.5, finder.median());
        finder.add(3);
        assertEquals(2.0, finder.median());
        finder.add(10);
        assertEquals(2.5, finder.median());
    }

    @Test
    void supportsValuesAddedOutOfOrder() {
        MedianFinder finder = new MedianFinder();
        finder.add(8);
        finder.add(1);
        finder.add(6);
        finder.add(2);
        finder.add(4);

        assertEquals(4.0, finder.median());
    }

    @Test
    void supportsNegativeValues() {
        MedianFinder finder = new MedianFinder();
        finder.add(-5);
        finder.add(-1);
        finder.add(-3);

        assertEquals(-3.0, finder.median());
    }

    @Test
    void supportsDuplicateValues() {
        MedianFinder finder = new MedianFinder();
        finder.add(4);
        finder.add(4);
        finder.add(4);
        finder.add(4);

        assertEquals(4.0, finder.median());
    }

    @Test
    void avoidsOverflowWhenAveragingLargeValues() {
        MedianFinder finder = new MedianFinder();
        finder.add(Integer.MAX_VALUE);
        finder.add(Integer.MAX_VALUE);

        assertEquals((double) Integer.MAX_VALUE, finder.median());
    }

    @Test
    void averagesOppositeIntegerBoundaries() {
        MedianFinder finder = new MedianFinder();
        finder.add(Integer.MIN_VALUE);
        finder.add(Integer.MAX_VALUE);

        assertEquals(-0.5, finder.median());
    }

    @Test
    void rejectsMedianRequestForEmptyStream() {
        MedianFinder finder = new MedianFinder();

        assertThrows(NoSuchElementException.class, finder::median);
    }
}
