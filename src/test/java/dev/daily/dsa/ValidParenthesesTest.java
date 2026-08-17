package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidParenthesesTest {
    @Test
    void returnsTrueForNestedValidBrackets() {
        assertTrue(ValidParentheses.isValid("({[]})"));
    }

    @Test
    void returnsFalseForWrongClosingOrder() {
        assertFalse(ValidParentheses.isValid("([)]"));
    }

    @Test
    void returnsFalseWhenClosingBracketAppearsFirst() {
        assertFalse(ValidParentheses.isValid("]"));
    }

    @Test
    void returnsFalseWhenOpeningBracketRemains() {
        assertFalse(ValidParentheses.isValid("(()"));
    }

    @Test
    void returnsTrueForEmptyString() {
        assertTrue(ValidParentheses.isValid(""));
    }
}

