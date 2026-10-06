package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InsertIntoBinarySearchTreeTest {
    @Test
    void insertsValueAtCorrectPosition() {
        InsertIntoBinarySearchTree.TreeNode root = sampleTree();

        InsertIntoBinarySearchTree.TreeNode result = InsertIntoBinarySearchTree.insert(root, 5);

        assertSame(root, result);
        assertEquals(5, root.right.left.value);
        assertNull(root.right.left.left);
        assertNull(root.right.left.right);
    }

    @Test
    void insertsDeepLeftValue() {
        InsertIntoBinarySearchTree.TreeNode root = sampleTree();

        InsertIntoBinarySearchTree.insert(root, 0);

        assertEquals(0, root.left.left.left.value);
    }

    @Test
    void insertsDeepRightValue() {
        InsertIntoBinarySearchTree.TreeNode root = sampleTree();

        InsertIntoBinarySearchTree.insert(root, 9);

        assertEquals(9, root.right.right.value);
    }

    @Test
    void createsRootForEmptyTree() {
        InsertIntoBinarySearchTree.TreeNode result =
                InsertIntoBinarySearchTree.insert(null, 4);

        assertEquals(4, result.value);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void rejectsDuplicateValue() {
        assertThrows(
                IllegalArgumentException.class,
                () -> InsertIntoBinarySearchTree.insert(sampleTree(), 3));
    }

    private static InsertIntoBinarySearchTree.TreeNode sampleTree() {
        InsertIntoBinarySearchTree.TreeNode root = node(4);
        root.left = node(2);
        root.right = node(7);
        root.left.left = node(1);
        root.left.right = node(3);
        return root;
    }

    private static InsertIntoBinarySearchTree.TreeNode node(int value) {
        return new InsertIntoBinarySearchTree.TreeNode(value);
    }
}
