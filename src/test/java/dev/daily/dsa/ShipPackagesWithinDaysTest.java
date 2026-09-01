package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShipPackagesWithinDaysTest {
    @Test
    void findsMinimumCapacityForSequentialPackages() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertEquals(15, ShipPackagesWithinDays.shipWithinDays(weights, 5));
    }

    @Test
    void handlesTighterDayLimit() {
        int[] weights = {3, 2, 2, 4, 1, 4};

        assertEquals(6, ShipPackagesWithinDays.shipWithinDays(weights, 3));
    }

    @Test
    void returnsTotalWeightWhenOnlyOneDayIsAllowed() {
        int[] weights = {1, 2, 3, 1, 1};

        assertEquals(8, ShipPackagesWithinDays.shipWithinDays(weights, 1));
    }

    @Test
    void returnsHeaviestPackageWhenEveryPackageCanShipSeparately() {
        int[] weights = {5, 1, 2, 3};

        assertEquals(5, ShipPackagesWithinDays.shipWithinDays(weights, 4));
    }

    @Test
    void preservesPackageOrderDuringFeasibilityCheck() {
        int[] weights = {10, 50, 50, 10};

        assertEquals(60, ShipPackagesWithinDays.shipWithinDays(weights, 2));
    }
}
