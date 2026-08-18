package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BackspaceStringCompareTest {
    @Test
    void returnsTrueWhenBackspacesProduceSameString() {
        assertTrue(BackspaceStringCompare.compare("ab#c", "ad#c"));
    }

    @Test
    void returnsTrueWhenBothStringsBecomeEmpty() {
        assertTrue(BackspaceStringCompare.compare("ab##", "c#d#"));
    }

    @Test
    void returnsFalseWhenFinalStringsDiffer() {
        assertFalse(BackspaceStringCompare.compare("a#c", "b"));
    }

    @Test
    void ignoresBackspaceWhenStringIsAlreadyEmpty() {
        assertTrue(BackspaceStringCompare.compare("###a", "a"));
    }
}
