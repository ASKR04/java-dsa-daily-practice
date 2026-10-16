package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ReorganizeStringTest {
    @Test
    void reorganizesRepeatedCharacters() {
        assertValidReorganization("aab", ReorganizeString.reorganize("aab"));
    }

    @Test
    void reorganizesSeveralCharacterGroups() {
        assertValidReorganization("vvvlo", ReorganizeString.reorganize("vvvlo"));
    }

    @Test
    void returnsEmptyStringWhenReorganizationIsImpossible() {
        assertEquals("", ReorganizeString.reorganize("aaab"));
    }

    @Test
    void handlesSingleCharacter() {
        assertEquals("z", ReorganizeString.reorganize("z"));
    }

    @Test
    void handlesEmptyString() {
        assertEquals("", ReorganizeString.reorganize(""));
    }

    @Test
    void rejectsNonLowercaseCharacter() {
        assertThrows(
                IllegalArgumentException.class,
                () -> ReorganizeString.reorganize("aA"));
    }

    private static void assertValidReorganization(String input, String result) {
        assertEquals(input.length(), result.length());
        assertArrayEquals(frequencies(input), frequencies(result));

        for (int index = 1; index < result.length(); index++) {
            assertNotEquals(result.charAt(index - 1), result.charAt(index));
        }
    }

    private static int[] frequencies(String value) {
        int[] frequencies = new int[26];
        for (int index = 0; index < value.length(); index++) {
            frequencies[value.charAt(index) - 'a']++;
        }
        return frequencies;
    }
}
