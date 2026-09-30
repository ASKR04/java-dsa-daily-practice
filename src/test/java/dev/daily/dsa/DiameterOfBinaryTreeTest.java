package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DiameterOfBinaryTreeTest {
    @Test
    void findsDiameterThroughRoot() {
        DiameterOfBinaryTree.TreeNode root = node(1);
        root.left = node(2);
        root.right = node(3);
        root.left.left = node(4);
        root.left.right = node(5);

        assertEquals(3, DiameterOfBinaryTree.diameter(root));
    }

    @Test
    void findsDiameterInsideSubtree() {
        DiameterOfBinaryTree.TreeNode root = node(1);
        root.left = node(2);
        root.right = node(9);
        root.left.left = node(3);
        root.left.right = node(4);
        root.left.left.left = node(5);
        root.left.left.left.left = node(7);
        root.left.right.right = node(6);
        root.left.right.right.right = node(8);

        assertEquals(6, DiameterOfBinaryTree.diameter(root));
    }

    @Test
    void findsDiameterOfSkewedTree() {
        DiameterOfBinaryTree.TreeNode root = node(1);
        root.right = node(2);
        root.right.right = node(3);
        root.right.right.right = node(4);

        assertEquals(3, DiameterOfBinaryTree.diameter(root));
    }

    @Test
    void returnsZeroForSingleNode() {
        assertEquals(0, DiameterOfBinaryTree.diameter(node(5)));
    }

    @Test
    void returnsZeroForEmptyTree() {
        assertEquals(0, DiameterOfBinaryTree.diameter(null));
    }

    private static DiameterOfBinaryTree.TreeNode node(int value) {
        return new DiameterOfBinaryTree.TreeNode(value);
    }
}
