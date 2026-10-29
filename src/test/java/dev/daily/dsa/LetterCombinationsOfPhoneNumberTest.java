package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class LetterCombinationsOfPhoneNumberTest {
    @Test
    void generatesCartesianProductForTwoDigits() {
        List<String> combinations =
                LetterCombinationsOfPhoneNumber.generate("23");

        Set<String> expected = Set.of(
                "ad", "ae", "af",
                "bd", "be", "bf",
                "cd", "ce", "cf");

        assertEquals(expected, new HashSet<>(combinations));
        assertEquals(expected.size(), combinations.size());
    }

    @Test
    void handlesDigitWithFourLetters() {
        assertEquals(
                List.of("p", "q", "r", "s"),
                LetterCombinationsOfPhoneNumber.generate("7"));
    }

    @Test
    void returnsEmptyListForEmptyDigits() {
        assertEquals(
                List.of(),
                LetterCombinationsOfPhoneNumber.generate(""));
    }

    @Test
    void generatesExpectedNumberOfLongerCombinations() {
        assertEquals(
                48,
                LetterCombinationsOfPhoneNumber.generate("279").size());
    }

    @Test
    void rejectsNullDigits() {
        assertThrows(
                NullPointerException.class,
                () -> LetterCombinationsOfPhoneNumber.generate(null));
    }

    @Test
    void rejectsUnsupportedCharacters() {
        assertThrows(
                IllegalArgumentException.class,
                () -> LetterCombinationsOfPhoneNumber.generate("10"));
        assertThrows(
                IllegalArgumentException.class,
                () -> LetterCombinationsOfPhoneNumber.generate("2a"));
    }
}
