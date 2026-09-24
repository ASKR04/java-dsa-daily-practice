package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class InvertBinaryTreeTest {
    @Test
    void invertsCompleteTree() {
        InvertBinaryTree.TreeNode root = node(4);
        root.left = node(2);
        root.right = node(7);
        root.left.left = node(1);
        root.left.right = node(3);
        root.right.left = node(6);
        root.right.right = node(9);

        InvertBinaryTree.TreeNode result = InvertBinaryTree.invert(root);

        assertSame(root, result);
        assertEquals(7, result.left.value);
        assertEquals(2, result.right.value);
        assertEquals(9, result.left.left.value);
        assertEquals(6, result.left.right.value);
        assertEquals(3, result.right.left.value);
        assertEquals(1, result.right.right.value);
    }

    @Test
    void invertsSparseTree() {
        InvertBinaryTree.TreeNode root = node(1);
        root.left = node(2);
        root.left.right = node(3);

        InvertBinaryTree.TreeNode result = InvertBinaryTree.invert(root);

        assertNull(result.left);
        assertEquals(2, result.right.value);
        assertEquals(3, result.right.left.value);
        assertNull(result.right.right);
    }

    @Test
    void keepsSingleNode() {
        InvertBinaryTree.TreeNode root = node(5);

        assertSame(root, InvertBinaryTree.invert(root));
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void handlesEmptyTree() {
        assertNull(InvertBinaryTree.invert(null));
    }

    private static InvertBinaryTree.TreeNode node(int value) {
        return new InvertBinaryTree.TreeNode(value);
    }
}
