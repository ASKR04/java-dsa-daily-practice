package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class BinaryTreeLevelOrderTraversalTest {
    @Test
    void traversesTreeOneLevelAtATime() {
        BinaryTreeLevelOrderTraversal.TreeNode root = node(3);
        root.left = node(9);
        root.right = node(20);
        root.right.left = node(15);
        root.right.right = node(7);

        List<List<Integer>> result = BinaryTreeLevelOrderTraversal.levelOrder(root);

        assertEquals(List.of(List.of(3), List.of(9, 20), List.of(15, 7)), result);
    }

    @Test
    void preservesLeftToRightOrderWithinEachLevel() {
        BinaryTreeLevelOrderTraversal.TreeNode root = node(1);
        root.left = node(2);
        root.right = node(3);
        root.left.left = node(4);
        root.left.right = node(5);
        root.right.left = node(6);

        List<List<Integer>> result = BinaryTreeLevelOrderTraversal.levelOrder(root);

        assertEquals(List.of(List.of(1), List.of(2, 3), List.of(4, 5, 6)), result);
    }

    @Test
    void traversesSkewedTree() {
        BinaryTreeLevelOrderTraversal.TreeNode root = node(1);
        root.right = node(2);
        root.right.right = node(3);

        assertEquals(
                List.of(List.of(1), List.of(2), List.of(3)),
                BinaryTreeLevelOrderTraversal.levelOrder(root));
    }

    @Test
    void handlesSingleNode() {
        assertEquals(
                List.of(List.of(8)),
                BinaryTreeLevelOrderTraversal.levelOrder(node(8)));
    }

    @Test
    void returnsEmptyListForEmptyTree() {
        assertEquals(List.of(), BinaryTreeLevelOrderTraversal.levelOrder(null));
    }

    private static BinaryTreeLevelOrderTraversal.TreeNode node(int value) {
        return new BinaryTreeLevelOrderTraversal.TreeNode(value);
    }
}
