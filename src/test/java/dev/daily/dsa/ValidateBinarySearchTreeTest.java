package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidateBinarySearchTreeTest {
    @Test
    void acceptsValidBinarySearchTree() {
        ValidateBinarySearchTree.TreeNode root = node(8);
        root.left = node(3);
        root.right = node(10);
        root.left.left = node(1);
        root.left.right = node(6);
        root.right.right = node(14);

        assertTrue(ValidateBinarySearchTree.isValid(root));
    }

    @Test
    void rejectsInvalidImmediateChild() {
        ValidateBinarySearchTree.TreeNode root = node(2);
        root.left = node(3);
        root.right = node(4);

        assertFalse(ValidateBinarySearchTree.isValid(root));
    }

    @Test
    void rejectsValueThatViolatesAncestorBound() {
        ValidateBinarySearchTree.TreeNode root = node(5);
        root.left = node(1);
        root.right = node(8);
        root.right.left = node(3);
        root.right.right = node(9);

        assertFalse(ValidateBinarySearchTree.isValid(root));
    }

    @Test
    void rejectsDuplicateValues() {
        ValidateBinarySearchTree.TreeNode root = node(2);
        root.left = node(1);
        root.right = node(2);

        assertFalse(ValidateBinarySearchTree.isValid(root));
    }

    @Test
    void supportsIntegerBoundaryValues() {
        ValidateBinarySearchTree.TreeNode root = node(0);
        root.left = node(Integer.MIN_VALUE);
        root.right = node(Integer.MAX_VALUE);

        assertTrue(ValidateBinarySearchTree.isValid(root));
    }

    @Test
    void acceptsEmptyTree() {
        assertTrue(ValidateBinarySearchTree.isValid(null));
    }

    private static ValidateBinarySearchTree.TreeNode node(int value) {
        return new ValidateBinarySearchTree.TreeNode(value);
    }
}
