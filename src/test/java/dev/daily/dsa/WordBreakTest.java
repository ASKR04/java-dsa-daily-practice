package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class WordBreakTest {
    @Test
    void segmentsTextUsingDictionaryWords() {
        assertTrue(WordBreak.canSegment(
                "leetcode", Set.of("leet", "code")));
    }

    @Test
    void canReuseTheSameDictionaryWord() {
        assertTrue(WordBreak.canSegment(
                "applepenapple", Set.of("apple", "pen")));
    }

    @Test
    void rejectsTextWithAnUnsegmentableSuffix() {
        assertFalse(WordBreak.canSegment(
                "catsandog", Set.of("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    void handlesEmptyInputsAndIgnoresEmptyWords() {
        assertTrue(WordBreak.canSegment("", Set.of()));
        assertFalse(WordBreak.canSegment("a", Set.of()));
        assertTrue(WordBreak.canSegment("a", Set.of("", "a")));
    }

    @Test
    void rejectsNullInputsAndDictionaryEntries() {
        assertThrows(
                NullPointerException.class,
                () -> WordBreak.canSegment(null, Set.of("a")));
        assertThrows(
                NullPointerException.class,
                () -> WordBreak.canSegment("a", null));

        Set<String> dictionary = new HashSet<>();
        dictionary.add(null);
        assertThrows(
                NullPointerException.class,
                () -> WordBreak.canSegment("a", dictionary));
    }
}
