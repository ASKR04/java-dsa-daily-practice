package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SameTreeTest {
    @Test
    void returnsTrueForIdenticalTrees() {
        SameTree.TreeNode first = node(1);
        first.left = node(2);
        first.right = node(3);

        SameTree.TreeNode second = node(1);
        second.left = node(2);
        second.right = node(3);

        assertTrue(SameTree.isSame(first, second));
    }

    @Test
    void returnsFalseForDifferentValues() {
        SameTree.TreeNode first = node(1);
        first.left = node(2);

        SameTree.TreeNode second = node(1);
        second.left = node(4);

        assertFalse(SameTree.isSame(first, second));
    }

    @Test
    void returnsFalseForDifferentStructures() {
        SameTree.TreeNode first = node(1);
        first.left = node(2);

        SameTree.TreeNode second = node(1);
        second.right = node(2);

        assertFalse(SameTree.isSame(first, second));
    }

    @Test
    void returnsTrueForTwoEmptyTrees() {
        assertTrue(SameTree.isSame(null, null));
    }

    @Test
    void returnsFalseWhenOnlyOneTreeIsEmpty() {
        assertFalse(SameTree.isSame(node(1), null));
        assertFalse(SameTree.isSame(null, node(1)));
    }

    private static SameTree.TreeNode node(int value) {
        return new SameTree.TreeNode(value);
    }
}
