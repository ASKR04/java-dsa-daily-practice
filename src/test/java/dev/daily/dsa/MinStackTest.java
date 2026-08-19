package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinStackTest {
    @Test
    void tracksMinimumAcrossPushes() {
        MinStack stack = new MinStack();

        stack.push(3);
        assertEquals(3, stack.getMin());

        stack.push(5);
        assertEquals(3, stack.getMin());

        stack.push(2);
        assertEquals(2, stack.getMin());
    }

    @Test
    void restoresPreviousMinimumAfterPop() {
        MinStack stack = new MinStack();

        stack.push(4);
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.getMin());
        assertEquals(1, stack.pop());
        assertEquals(4, stack.getMin());
    }

    @Test
    void handlesDuplicateMinimumValues() {
        MinStack stack = new MinStack();

        stack.push(2);
        stack.push(2);
        stack.push(3);

        assertEquals(2, stack.getMin());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(2, stack.getMin());
    }

    @Test
    void exposesTopWithoutRemovingIt() {
        MinStack stack = new MinStack();

        stack.push(7);
        stack.push(9);

        assertEquals(9, stack.top());
        assertEquals(9, stack.top());
        assertFalse(stack.empty());
    }

    @Test
    void throwsWhenReadingFromEmptyStack() {
        MinStack stack = new MinStack();

        assertTrue(stack.empty());
        assertThrows(NoSuchElementException.class, stack::pop);
        assertThrows(NoSuchElementException.class, stack::top);
        assertThrows(NoSuchElementException.class, stack::getMin);
    }
}
