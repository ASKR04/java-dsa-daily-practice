package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class GenerateParenthesesTest {
    @Test
    void generatesEveryValidCombinationForThreePairs() {
        List<String> combinations = GenerateParentheses.generate(3);

        Set<String> expected = Set.of(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()");

        assertEquals(expected, new HashSet<>(combinations));
        assertEquals(expected.size(), combinations.size());
    }

    @Test
    void returnsEmptyStringForZeroPairs() {
        assertEquals(List.of(""), GenerateParentheses.generate(0));
    }

    @Test
    void handlesOnePair() {
        assertEquals(List.of("()"), GenerateParentheses.generate(1));
    }

    @Test
    void generatesFourthCatalanNumberOfCombinations() {
        assertEquals(14, GenerateParentheses.generate(4).size());
    }

    @Test
    void rejectsNegativePairCount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> GenerateParentheses.generate(-1));
    }
}
