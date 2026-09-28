package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BalancedBinaryTreeTest {
    @Test
    void returnsTrueForBalancedTree() {
        BalancedBinaryTree.TreeNode root = node(3);
        root.left = node(9);
        root.right = node(20);
        root.right.left = node(15);
        root.right.right = node(7);

        assertTrue(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    void returnsFalseForUnbalancedTree() {
        BalancedBinaryTree.TreeNode root = node(1);
        root.left = node(2);
        root.right = node(2);
        root.left.left = node(3);
        root.left.right = node(3);
        root.left.left.left = node(4);
        root.left.left.right = node(4);

        assertFalse(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    void detectsImbalanceInsideSubtree() {
        BalancedBinaryTree.TreeNode root = node(1);
        root.left = node(2);
        root.right = node(3);
        root.right.left = node(4);
        root.right.right = node(5);
        root.right.right.right = node(6);
        root.right.right.right.right = node(7);

        assertFalse(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    void returnsTrueForSingleNode() {
        assertTrue(BalancedBinaryTree.isBalanced(node(8)));
    }

    @Test
    void returnsTrueForEmptyTree() {
        assertTrue(BalancedBinaryTree.isBalanced(null));
    }

    private static BalancedBinaryTree.TreeNode node(int value) {
        return new BalancedBinaryTree.TreeNode(value);
    }
}
