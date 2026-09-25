package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PathSumTest {
    @Test
    void findsMatchingRootToLeafPath() {
        PathSum.TreeNode root = node(5);
        root.left = node(4);
        root.right = node(8);
        root.left.left = node(11);
        root.left.left.left = node(7);
        root.left.left.right = node(2);
        root.right.left = node(13);
        root.right.right = node(4);
        root.right.right.right = node(1);

        assertTrue(PathSum.hasPathSum(root, 22));
    }

    @Test
    void rejectsSumThatStopsBeforeLeaf() {
        PathSum.TreeNode root = node(1);
        root.left = node(2);

        assertFalse(PathSum.hasPathSum(root, 1));
    }

    @Test
    void supportsNegativeValues() {
        PathSum.TreeNode root = node(-2);
        root.right = node(-3);

        assertTrue(PathSum.hasPathSum(root, -5));
        assertFalse(PathSum.hasPathSum(root, -2));
    }

    @Test
    void handlesSingleNodeTree() {
        PathSum.TreeNode root = node(7);

        assertTrue(PathSum.hasPathSum(root, 7));
        assertFalse(PathSum.hasPathSum(root, 8));
    }

    @Test
    void returnsFalseForEmptyTree() {
        assertFalse(PathSum.hasPathSum(null, 0));
    }

    private static PathSum.TreeNode node(int value) {
        return new PathSum.TreeNode(value);
    }
}
