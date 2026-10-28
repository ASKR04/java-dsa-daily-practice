package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class SubsetsTest {
    @Test
    void generatesEverySubset() {
        List<List<Integer>> subsets = Subsets.generate(new int[] {1, 2, 3});

        Set<List<Integer>> expected = Set.of(
                List.of(),
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(1, 2),
                List.of(1, 3),
                List.of(2, 3),
                List.of(1, 2, 3));

        assertEquals(expected, new HashSet<>(subsets));
        assertEquals(expected.size(), subsets.size());
    }

    @Test
    void returnsEmptySubsetForEmptyInput() {
        assertEquals(List.of(List.of()), Subsets.generate(new int[0]));
    }

    @Test
    void handlesOneElement() {
        assertEquals(
                Set.of(List.of(), List.of(7)),
                new HashSet<>(Subsets.generate(new int[] {7})));
    }

    @Test
    void doesNotModifyInput() {
        int[] numbers = {3, 1, 2};

        Subsets.generate(numbers);

        assertEquals(List.of(3, 1, 2),
                List.of(numbers[0], numbers[1], numbers[2]));
    }

    @Test
    void rejectsNullInput() {
        assertThrows(NullPointerException.class, () -> Subsets.generate(null));
    }
}
