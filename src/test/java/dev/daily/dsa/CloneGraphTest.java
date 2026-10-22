package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class CloneGraphTest {
    @Test
    void clonesConnectedGraphWithCycle() {
        CloneGraph.Node first = new CloneGraph.Node(1);
        CloneGraph.Node second = new CloneGraph.Node(2);
        CloneGraph.Node third = new CloneGraph.Node(3);
        first.connect(second);
        second.connect(third);
        third.connect(first);

        CloneGraph.Node clone = CloneGraph.cloneGraph(first);
        CloneGraph.Node secondClone = clone.neighbors().get(0);
        CloneGraph.Node thirdClone = secondClone.neighbors().get(0);

        assertNotSame(first, clone);
        assertNotSame(second, secondClone);
        assertNotSame(third, thirdClone);
        assertEquals(1, clone.value());
        assertEquals(2, secondClone.value());
        assertEquals(3, thirdClone.value());
        assertSame(clone, thirdClone.neighbors().get(0));
    }

    @Test
    void preservesSelfLoopAndDuplicateEdges() {
        CloneGraph.Node node = new CloneGraph.Node(7);
        node.connect(node);
        node.connect(node);

        CloneGraph.Node clone = CloneGraph.cloneGraph(node);

        assertEquals(2, clone.neighbors().size());
        assertSame(clone, clone.neighbors().get(0));
        assertSame(clone, clone.neighbors().get(1));
    }

    @Test
    void distinguishesNodesThatShareTheSameValue() {
        CloneGraph.Node first = new CloneGraph.Node(5);
        CloneGraph.Node second = new CloneGraph.Node(5);
        first.connect(second);

        CloneGraph.Node clone = CloneGraph.cloneGraph(first);

        assertNotSame(clone, clone.neighbors().get(0));
        assertEquals(5, clone.neighbors().get(0).value());
    }

    @Test
    void changesToCloneDoNotAffectOriginal() {
        CloneGraph.Node original = new CloneGraph.Node(1);
        original.connect(new CloneGraph.Node(2));

        CloneGraph.Node clone = CloneGraph.cloneGraph(original);
        clone.connect(new CloneGraph.Node(3));

        assertEquals(1, original.neighbors().size());
        assertEquals(2, clone.neighbors().size());
    }

    @Test
    void returnsNullForEmptyGraph() {
        assertNull(CloneGraph.cloneGraph(null));
    }
}
