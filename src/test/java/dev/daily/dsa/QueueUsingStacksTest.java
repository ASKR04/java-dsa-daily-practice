package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueueUsingStacksTest {
    @Test
    void popsValuesInFirstInFirstOutOrder() {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());
        assertTrue(queue.empty());
    }

    @Test
    void peekDoesNotRemoveTheFrontValue() {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.push(10);
        queue.push(20);

        assertEquals(10, queue.peek());
        assertEquals(10, queue.pop());
        assertFalse(queue.empty());
    }

    @Test
    void preservesOrderWhenPushesHappenAfterPops() {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.push(5);
        queue.push(6);
        assertEquals(5, queue.pop());

        queue.push(7);

        assertEquals(6, queue.pop());
        assertEquals(7, queue.pop());
    }

    @Test
    void throwsWhenReadingFromAnEmptyQueue() {
        QueueUsingStacks queue = new QueueUsingStacks();

        assertThrows(NoSuchElementException.class, queue::pop);
        assertThrows(NoSuchElementException.class, queue::peek);
    }
}
