package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ConstructBinarySearchTreeFromPreorderTraversalTest {
    @Test
    void constructsBinarySearchTreeFromPreorder() {
        ConstructBinarySearchTreeFromPreorderTraversal.TreeNode root =
                ConstructBinarySearchTreeFromPreorderTraversal.build(
                        new int[] {8, 5, 1, 7, 10, 12});

        assertEquals(8, root.value);
        assertEquals(5, root.left.value);
        assertEquals(1, root.left.left.value);
        assertEquals(7, root.left.right.value);
        assertEquals(10, root.right.value);
        assertEquals(12, root.right.right.value);
        assertArrayEquals(new int[] {1, 5, 7, 8, 10, 12}, inorder(root));
    }

    @Test
    void constructsRightSkewedTree() {
        ConstructBinarySearchTreeFromPreorderTraversal.TreeNode root =
                ConstructBinarySearchTreeFromPreorderTraversal.build(new int[] {1, 2, 3});

        assertNull(root.left);
        assertEquals(2, root.right.value);
        assertEquals(3, root.right.right.value);
    }

    @Test
    void constructsLeftSkewedTree() {
        ConstructBinarySearchTreeFromPreorderTraversal.TreeNode root =
                ConstructBinarySearchTreeFromPreorderTraversal.build(new int[] {3, 2, 1});

        assertNull(root.right);
        assertEquals(2, root.left.value);
        assertEquals(1, root.left.left.value);
    }

    @Test
    void handlesEmptyTraversal() {
        assertNull(ConstructBinarySearchTreeFromPreorderTraversal.build(new int[0]));
    }

    @Test
    void rejectsInvalidPreorderTraversal() {
        assertThrows(
                IllegalArgumentException.class,
                () -> ConstructBinarySearchTreeFromPreorderTraversal.build(
                        new int[] {8, 10, 5}));
    }

    @Test
    void rejectsDuplicateValues() {
        assertThrows(
                IllegalArgumentException.class,
                () -> ConstructBinarySearchTreeFromPreorderTraversal.build(
                        new int[] {4, 2, 2}));
    }

    private static int[] inorder(
            ConstructBinarySearchTreeFromPreorderTraversal.TreeNode root) {
        List<Integer> values = new ArrayList<>();
        collectInorder(root, values);
        return values.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void collectInorder(
            ConstructBinarySearchTreeFromPreorderTraversal.TreeNode node,
            List<Integer> values) {
        if (node == null) {
            return;
        }

        collectInorder(node.left, values);
        values.add(node.value);
        collectInorder(node.right, values);
    }
}
