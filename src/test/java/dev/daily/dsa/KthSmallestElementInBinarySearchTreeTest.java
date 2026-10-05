package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class KthSmallestElementInBinarySearchTreeTest {
    @Test
    void findsSmallestValue() {
        KthSmallestElementInBinarySearchTree.TreeNode root = sampleTree();

        assertEquals(1, KthSmallestElementInBinarySearchTree.kthSmallest(root, 1));
    }

    @Test
    void findsValueInMiddleOfTraversal() {
        KthSmallestElementInBinarySearchTree.TreeNode root = sampleTree();

        assertEquals(4, KthSmallestElementInBinarySearchTree.kthSmallest(root, 4));
    }

    @Test
    void findsLargestValue() {
        KthSmallestElementInBinarySearchTree.TreeNode root = sampleTree();

        assertEquals(6, KthSmallestElementInBinarySearchTree.kthSmallest(root, 6));
    }

    @Test
    void worksForSkewedTree() {
        KthSmallestElementInBinarySearchTree.TreeNode root = node(1);
        root.right = node(2);
        root.right.right = node(3);

        assertEquals(2, KthSmallestElementInBinarySearchTree.kthSmallest(root, 2));
    }

    @Test
    void rejectsNonPositiveK() {
        assertThrows(
                IllegalArgumentException.class,
                () -> KthSmallestElementInBinarySearchTree.kthSmallest(sampleTree(), 0));
    }

    @Test
    void rejectsKGreaterThanNodeCount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> KthSmallestElementInBinarySearchTree.kthSmallest(sampleTree(), 7));
    }

    private static KthSmallestElementInBinarySearchTree.TreeNode sampleTree() {
        KthSmallestElementInBinarySearchTree.TreeNode root = node(5);
        root.left = node(3);
        root.right = node(6);
        root.left.left = node(2);
        root.left.right = node(4);
        root.left.left.left = node(1);
        return root;
    }

    private static KthSmallestElementInBinarySearchTree.TreeNode node(int value) {
        return new KthSmallestElementInBinarySearchTree.TreeNode(value);
    }
}
