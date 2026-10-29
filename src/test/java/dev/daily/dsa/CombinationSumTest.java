package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CombinationSumTest {
    @Test
    void findsCombinationsWithReusableCandidates() {
        List<List<Integer>> combinations =
                CombinationSum.find(new int[] {2, 3, 6, 7}, 7);

        assertEquals(
                Set.of(List.of(2, 2, 3), List.of(7)),
                new HashSet<>(combinations));
        assertEquals(2, combinations.size());
    }

    @Test
    void findsAllCombinationsForUnsortedInput() {
        List<List<Integer>> combinations =
                CombinationSum.find(new int[] {5, 2, 3}, 8);

        assertEquals(
                Set.of(
                        List.of(2, 2, 2, 2),
                        List.of(2, 3, 3),
                        List.of(3, 5)),
                new HashSet<>(combinations));
    }

    @Test
    void returnsEmptyCombinationForZeroTarget() {
        assertEquals(
                List.of(List.of()),
                CombinationSum.find(new int[] {2, 3}, 0));
    }

    @Test
    void returnsEmptyListWhenNoCombinationExists() {
        assertEquals(List.of(), CombinationSum.find(new int[] {4, 6}, 5));
    }

    @Test
    void doesNotModifyCandidates() {
        int[] candidates = {7, 2, 3};
        int[] original = candidates.clone();

        CombinationSum.find(candidates, 7);

        assertArrayEquals(original, candidates);
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> CombinationSum.find(null, 7));
        assertThrows(
                IllegalArgumentException.class,
                () -> CombinationSum.find(new int[] {2, 0}, 7));
        assertThrows(
                IllegalArgumentException.class,
                () -> CombinationSum.find(new int[] {2, 2}, 7));
        assertThrows(
                IllegalArgumentException.class,
                () -> CombinationSum.find(new int[] {2, 3}, -1));
    }
}
