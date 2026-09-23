package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MaximumDepthOfBinaryTreeTest {
    @Test
    void findsDepthOfBalancedTree() {
        MaximumDepthOfBinaryTree.TreeNode root = node(3);
        root.left = node(9);
        root.right = node(20);
        root.right.left = node(15);
        root.right.right = node(7);

        assertEquals(3, MaximumDepthOfBinaryTree.maxDepth(root));
    }

    @Test
    void findsDepthOfSkewedTree() {
        MaximumDepthOfBinaryTree.TreeNode root = node(1);
        root.right = node(2);
        root.right.right = node(3);
        root.right.right.left = node(4);

        assertEquals(4, MaximumDepthOfBinaryTree.maxDepth(root));
    }

    @Test
    void returnsOneForSingleNode() {
        assertEquals(1, MaximumDepthOfBinaryTree.maxDepth(node(8)));
    }

    @Test
    void returnsZeroForEmptyTree() {
        assertEquals(0, MaximumDepthOfBinaryTree.maxDepth(null));
    }

    private static MaximumDepthOfBinaryTree.TreeNode node(int value) {
        return new MaximumDepthOfBinaryTree.TreeNode(value);
    }
}
