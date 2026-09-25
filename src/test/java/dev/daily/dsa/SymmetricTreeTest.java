package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SymmetricTreeTest {
    @Test
    void returnsTrueForSymmetricTree() {
        SymmetricTree.TreeNode root = node(1);
        root.left = node(2);
        root.right = node(2);
        root.left.left = node(3);
        root.left.right = node(4);
        root.right.left = node(4);
        root.right.right = node(3);

        assertTrue(SymmetricTree.isSymmetric(root));
    }

    @Test
    void returnsFalseForAsymmetricStructure() {
        SymmetricTree.TreeNode root = node(1);
        root.left = node(2);
        root.right = node(2);
        root.left.right = node(3);
        root.right.right = node(3);

        assertFalse(SymmetricTree.isSymmetric(root));
    }

    @Test
    void returnsFalseForDifferentMirrorValues() {
        SymmetricTree.TreeNode root = node(1);
        root.left = node(2);
        root.right = node(2);
        root.left.left = node(3);
        root.right.right = node(4);

        assertFalse(SymmetricTree.isSymmetric(root));
    }

    @Test
    void returnsTrueForSingleNode() {
        assertTrue(SymmetricTree.isSymmetric(node(7)));
    }

    @Test
    void returnsTrueForEmptyTree() {
        assertTrue(SymmetricTree.isSymmetric(null));
    }

    private static SymmetricTree.TreeNode node(int value) {
        return new SymmetricTree.TreeNode(value);
    }
}
