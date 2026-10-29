package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PermutationsTest {
    @Test
    void generatesEveryPermutation() {
        List<List<Integer>> permutations =
                Permutations.generate(new int[] {1, 2, 3});

        Set<List<Integer>> expected = Set.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1));

        assertEquals(expected, new HashSet<>(permutations));
        assertEquals(expected.size(), permutations.size());
    }

    @Test
    void returnsOneEmptyPermutationForEmptyInput() {
        assertEquals(List.of(List.of()), Permutations.generate(new int[0]));
    }

    @Test
    void handlesOneElement() {
        assertEquals(List.of(List.of(7)), Permutations.generate(new int[] {7}));
    }

    @Test
    void handlesNegativeValues() {
        assertEquals(
                Set.of(List.of(-1, 2), List.of(2, -1)),
                new HashSet<>(Permutations.generate(new int[] {-1, 2})));
    }

    @Test
    void doesNotModifyInput() {
        int[] numbers = {3, 1, 2};
        int[] original = numbers.clone();

        Permutations.generate(numbers);

        assertArrayEquals(original, numbers);
    }

    @Test
    void rejectsNullInput() {
        assertThrows(
                NullPointerException.class,
                () -> Permutations.generate(null));
    }
}
