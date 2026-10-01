package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class BinaryTreeRightSideViewTest {
    @Test
    void returnsRightmostNodeAtEachLevel() {
        BinaryTreeRightSideView.TreeNode root = node(1);
        root.left = node(2);
        root.right = node(3);
        root.left.right = node(5);
        root.right.right = node(4);

        assertEquals(List.of(1, 3, 4), BinaryTreeRightSideView.rightSideView(root));
    }

    @Test
    void usesLeftNodeWhenRightSideHasNoNodeAtDepth() {
        BinaryTreeRightSideView.TreeNode root = node(1);
        root.left = node(2);
        root.right = node(3);
        root.left.left = node(4);

        assertEquals(List.of(1, 3, 4), BinaryTreeRightSideView.rightSideView(root));
    }

    @Test
    void traversesLeftSkewedTree() {
        BinaryTreeRightSideView.TreeNode root = node(1);
        root.left = node(2);
        root.left.left = node(3);

        assertEquals(List.of(1, 2, 3), BinaryTreeRightSideView.rightSideView(root));
    }

    @Test
    void handlesSingleNode() {
        assertEquals(List.of(8), BinaryTreeRightSideView.rightSideView(node(8)));
    }

    @Test
    void returnsEmptyListForEmptyTree() {
        assertEquals(List.of(), BinaryTreeRightSideView.rightSideView(null));
    }

    private static BinaryTreeRightSideView.TreeNode node(int value) {
        return new BinaryTreeRightSideView.TreeNode(value);
    }
}
