package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PeakIndexInMountainArrayTest {
    @Test
    void findsPeakInSmallMountain() {
        int[] arr = {0, 1, 0};

        assertEquals(1, PeakIndexInMountainArray.peakIndex(arr));
    }

    @Test
    void findsPeakNearMiddle() {
        int[] arr = {0, 2, 5, 7, 4, 1};

        assertEquals(3, PeakIndexInMountainArray.peakIndex(arr));
    }

    @Test
    void findsPeakNearStart() {
        int[] arr = {1, 9, 7, 3, 2};

        assertEquals(1, PeakIndexInMountainArray.peakIndex(arr));
    }

    @Test
    void findsPeakNearEnd() {
        int[] arr = {1, 3, 5, 8, 10, 4};

        assertEquals(4, PeakIndexInMountainArray.peakIndex(arr));
    }
}
