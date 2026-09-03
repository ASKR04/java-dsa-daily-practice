package dev.daily.dsa;

public final class PeakIndexInMountainArray {
    private PeakIndexInMountainArray() {
    }

    public static int peakIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] < arr[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }
}
