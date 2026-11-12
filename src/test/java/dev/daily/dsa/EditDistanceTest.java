package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EditDistanceTest {
    @Test
    void combinesReplaceAndDeleteOperations() {
        assertEquals(3, EditDistance.distance("horse", "ros"));
    }

    @Test
    void handlesLongerTransformation() {
        assertEquals(5, EditDistance.distance("intention", "execution"));
    }

    @Test
    void handlesEmptyAndIdenticalStrings() {
        assertEquals(3, EditDistance.distance("", "abc"));
        assertEquals(3, EditDistance.distance("abc", ""));
        assertEquals(0, EditDistance.distance("same", "same"));
    }

    @Test
    void givesTheSameDistanceInEitherDirection() {
        assertEquals(
                EditDistance.distance("kitten", "sitting"),
                EditDistance.distance("sitting", "kitten"));
    }

    @Test
    void rejectsNullInputs() {
        assertThrows(
                NullPointerException.class,
                () -> EditDistance.distance(null, "abc"));
        assertThrows(
                NullPointerException.class,
                () -> EditDistance.distance("abc", null));
    }
}
