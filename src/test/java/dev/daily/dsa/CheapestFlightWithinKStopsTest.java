package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CheapestFlightWithinKStopsTest {
    @Test
    void findsCheaperRouteWithOneStop() {
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {0, 2, 500}
        };

        assertEquals(
                200,
                CheapestFlightWithinKStops.findCheapestPrice(
                        3, flights, 0, 2, 1));
    }

    @Test
    void respectsMaximumStopCount() {
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {0, 2, 500}
        };

        assertEquals(
                500,
                CheapestFlightWithinKStops.findCheapestPrice(
                        3, flights, 0, 2, 0));
    }

    @Test
    void handlesSeveralAllowedStops() {
        int[][] flights = {
            {0, 1, 5},
            {1, 2, 5},
            {2, 3, 5},
            {0, 3, 30}
        };

        assertEquals(
                15,
                CheapestFlightWithinKStops.findCheapestPrice(
                        4, flights, 0, 3, 2));
    }

    @Test
    void returnsMinusOneWhenDestinationIsUnreachable() {
        assertEquals(
                -1,
                CheapestFlightWithinKStops.findCheapestPrice(
                        3, new int[][] {{0, 1, 10}}, 0, 2, 1));
    }

    @Test
    void returnsZeroWhenSourceIsDestination() {
        assertEquals(
                0,
                CheapestFlightWithinKStops.findCheapestPrice(
                        2, new int[][] {{0, 1, 10}}, 1, 1, 0));
    }

    @Test
    void doesNotModifyFlights() {
        int[][] flights = {{0, 1, 10}, {1, 2, 20}};
        int[][] original = {flights[0].clone(), flights[1].clone()};

        CheapestFlightWithinKStops.findCheapestPrice(3, flights, 0, 2, 1);

        assertArrayEquals(original[0], flights[0]);
        assertArrayEquals(original[1], flights[1]);
    }

    @Test
    void rejectsNegativeMaximumStops() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CheapestFlightWithinKStops.findCheapestPrice(
                        2, new int[0][], 0, 1, -1));
    }

    @Test
    void rejectsInvalidFlightPrice() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CheapestFlightWithinKStops.findCheapestPrice(
                        2, new int[][] {{0, 1, -5}}, 0, 1, 0));
    }
}
