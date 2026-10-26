package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NetworkDelayTimeTest {
    @Test
    void findsTimeToReachEveryNode() {
        int[][] times = {
            {2, 1, 1},
            {2, 3, 1},
            {3, 4, 1}
        };

        assertEquals(2, NetworkDelayTime.minimumDelay(4, times, 2));
    }

    @Test
    void choosesCheaperIndirectPath() {
        int[][] times = {
            {1, 2, 10},
            {1, 3, 2},
            {3, 2, 3},
            {2, 4, 1},
            {3, 4, 20}
        };

        assertEquals(6, NetworkDelayTime.minimumDelay(4, times, 1));
    }

    @Test
    void returnsMinusOneWhenNodeIsUnreachable() {
        assertEquals(
                -1,
                NetworkDelayTime.minimumDelay(3, new int[][] {{1, 2, 5}}, 1));
    }

    @Test
    void returnsZeroForSingleNode() {
        assertEquals(0, NetworkDelayTime.minimumDelay(1, new int[0][], 1));
    }

    @Test
    void supportsZeroTravelTime() {
        assertEquals(
                0,
                NetworkDelayTime.minimumDelay(2, new int[][] {{1, 2, 0}}, 1));
    }

    @Test
    void doesNotModifyTimes() {
        int[][] times = {{1, 2, 3}, {2, 3, 4}};
        int[][] original = {times[0].clone(), times[1].clone()};

        NetworkDelayTime.minimumDelay(3, times, 1);

        assertArrayEquals(original[0], times[0]);
        assertArrayEquals(original[1], times[1]);
    }

    @Test
    void rejectsNegativeTravelTime() {
        assertThrows(
                IllegalArgumentException.class,
                () -> NetworkDelayTime.minimumDelay(
                        2, new int[][] {{1, 2, -1}}, 1));
    }

    @Test
    void rejectsInvalidSource() {
        assertThrows(
                IllegalArgumentException.class,
                () -> NetworkDelayTime.minimumDelay(2, new int[0][], 0));
    }
}
