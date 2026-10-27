package dev.daily.dsa;

import java.util.Arrays;
import java.util.Objects;

public final class CheapestFlightWithinKStops {
    private CheapestFlightWithinKStops() {
    }

    public static int findCheapestPrice(
            int cityCount,
            int[][] flights,
            int source,
            int destination,
            int maximumStops) {
        if (cityCount <= 0) {
            throw new IllegalArgumentException("cityCount must be positive");
        }
        validateCity(source, cityCount, "source");
        validateCity(destination, cityCount, "destination");
        if (maximumStops < 0) {
            throw new IllegalArgumentException("maximumStops must not be negative");
        }
        Objects.requireNonNull(flights, "flights must not be null");

        for (int[] flight : flights) {
            validateFlight(flight, cityCount);
        }

        long[] prices = new long[cityCount];
        Arrays.fill(prices, Long.MAX_VALUE);
        prices[source] = 0;

        for (int edgesUsed = 0; edgesUsed <= maximumStops; edgesUsed++) {
            long[] nextPrices = prices.clone();
            for (int[] flight : flights) {
                int departure = flight[0];
                int arrival = flight[1];
                int price = flight[2];
                if (prices[departure] != Long.MAX_VALUE) {
                    nextPrices[arrival] = Math.min(
                            nextPrices[arrival],
                            prices[departure] + price);
                }
            }
            prices = nextPrices;
        }

        return prices[destination] == Long.MAX_VALUE
                ? -1
                : Math.toIntExact(prices[destination]);
    }

    private static void validateCity(int city, int cityCount, String name) {
        if (city < 0 || city >= cityCount) {
            throw new IllegalArgumentException(name + " must be a valid city index");
        }
    }

    private static void validateFlight(int[] flight, int cityCount) {
        if (flight == null || flight.length != 3) {
            throw new IllegalArgumentException(
                    "each flight must contain departure, arrival, and price");
        }
        validateCity(flight[0], cityCount, "departure");
        validateCity(flight[1], cityCount, "arrival");
        if (flight[2] < 0) {
            throw new IllegalArgumentException("flight price must not be negative");
        }
    }
}
