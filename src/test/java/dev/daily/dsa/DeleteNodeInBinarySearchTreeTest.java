package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DeleteNodeInBinarySearchTreeTest {
    @Test
    void deletesLeafNode() {
        DeleteNodeInBinarySearchTree.TreeNode root = sampleTree();

        root = DeleteNodeInBinarySearchTree.delete(root, 2);

        assertEquals(List.of(3, 4, 5, 6, 7), inorder(root));
        assertNull(root.left.left);
    }

    @Test
    void deletesNodeWithOneChild() {
        DeleteNodeInBinarySearchTree.TreeNode root = sampleTree();

        root = DeleteNodeInBinarySearchTree.delete(root, 6);

        assertEquals(List.of(2, 3, 4, 5, 7), inorder(root));
        assertEquals(7, root.right.value);
    }

    @Test
    void deletesNodeWithTwoChildren() {
        DeleteNodeInBinarySearchTree.TreeNode root = sampleTree();

        root = DeleteNodeInBinarySearchTree.delete(root, 3);

        assertEquals(List.of(2, 4, 5, 6, 7), inorder(root));
        assertEquals(4, root.left.value);
        assertEquals(2, root.left.left.value);
    }

    @Test
    void deletesRootWithTwoChildren() {
        DeleteNodeInBinarySearchTree.TreeNode root = sampleTree();

        root = DeleteNodeInBinarySearchTree.delete(root, 5);

        assertEquals(List.of(2, 3, 4, 6, 7), inorder(root));
        assertEquals(6, root.value);
    }

    @Test
    void leavesTreeUnchangedWhenKeyIsMissing() {
        DeleteNodeInBinarySearchTree.TreeNode root = sampleTree();

        DeleteNodeInBinarySearchTree.TreeNode result =
                DeleteNodeInBinarySearchTree.delete(root, 10);

        assertSame(root, result);
        assertEquals(List.of(2, 3, 4, 5, 6, 7), inorder(result));
    }

    @Test
    void handlesEmptyTree() {
        assertNull(DeleteNodeInBinarySearchTree.delete(null, 1));
    }

    private static DeleteNodeInBinarySearchTree.TreeNode sampleTree() {
        DeleteNodeInBinarySearchTree.TreeNode root = node(5);
        root.left = node(3);
        root.right = node(6);
        root.left.left = node(2);
        root.left.right = node(4);
        root.right.right = node(7);
        return root;
    }

    private static List<Integer> inorder(DeleteNodeInBinarySearchTree.TreeNode root) {
        List<Integer> values = new ArrayList<>();
        collectInorder(root, values);
        return values;
    }

    private static void collectInorder(
            DeleteNodeInBinarySearchTree.TreeNode node,
            List<Integer> values) {
        if (node == null) {
            return;
        }

        collectInorder(node.left, values);
        values.add(node.value);
        collectInorder(node.right, values);
    }

    private static DeleteNodeInBinarySearchTree.TreeNode node(int value) {
        return new DeleteNodeInBinarySearchTree.TreeNode(value);
    }
}
