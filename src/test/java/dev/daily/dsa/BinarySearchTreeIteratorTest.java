package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class BinarySearchTreeIteratorTest {
    @Test
    void returnsValuesInAscendingOrder() {
        BinarySearchTreeIterator.TreeNode root = node(7);
        root.left = node(3);
        root.right = node(15);
        root.right.left = node(9);
        root.right.right = node(20);
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(root);

        assertEquals(3, iterator.next());
        assertEquals(7, iterator.next());
        assertEquals(9, iterator.next());
        assertEquals(15, iterator.next());
        assertEquals(20, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void handlesEmptyTree() {
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(null);

        assertFalse(iterator.hasNext());
    }

    @Test
    void handlesLeftSkewedTree() {
        BinarySearchTreeIterator.TreeNode root = node(3);
        root.left = node(2);
        root.left.left = node(1);
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(root);

        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
    }

    @Test
    void hasNextDoesNotAdvanceIterator() {
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(node(4));

        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void nextThrowsWhenIteratorIsExhausted() {
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(node(1));
        iterator.next();

        assertThrows(NoSuchElementException.class, iterator::next);
    }

    private static BinarySearchTreeIterator.TreeNode node(int value) {
        return new BinarySearchTreeIterator.TreeNode(value);
    }
}
