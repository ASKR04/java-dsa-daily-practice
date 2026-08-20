package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DailyTemperaturesTest {
    @Test
    void returnsWaitsUntilNextWarmerTemperature() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        assertArrayEquals(
                new int[] {1, 1, 4, 2, 1, 1, 0, 0},
                DailyTemperatures.daysUntilWarmer(temperatures)
        );
    }

    @Test
    void returnsZeroesWhenNoWarmerFutureDayExists() {
        int[] temperatures = {80, 79, 78, 77};

        assertArrayEquals(
                new int[] {0, 0, 0, 0},
                DailyTemperatures.daysUntilWarmer(temperatures)
        );
    }

    @Test
    void handlesStrictlyIncreasingTemperatures() {
        int[] temperatures = {60, 61, 62, 63};

        assertArrayEquals(
                new int[] {1, 1, 1, 0},
                DailyTemperatures.daysUntilWarmer(temperatures)
        );
    }

    @Test
    void doesNotTreatEqualTemperaturesAsWarmer() {
        int[] temperatures = {70, 70, 71};

        assertArrayEquals(
                new int[] {2, 1, 0},
                DailyTemperatures.daysUntilWarmer(temperatures)
        );
    }
}
