package dev.daily.dsa;

public final class ShipPackagesWithinDays {
    private ShipPackagesWithinDays() {
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        int answer = right;

        while (left <= right) {
            int capacity = left + (right - left) / 2;

            if (canShip(weights, days, capacity)) {
                answer = capacity;
                right = capacity - 1;
            } else {
                left = capacity + 1;
            }
        }

        return answer;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {
        int usedDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                usedDays++;
                currentLoad = 0;
            }

            currentLoad += weight;

            if (usedDays > days) {
                return false;
            }
        }

        return true;
    }
}
