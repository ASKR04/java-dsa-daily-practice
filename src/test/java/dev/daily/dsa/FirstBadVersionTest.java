package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FirstBadVersionTest {
    @Test
    void findsFirstBadVersionInMiddleOfRange() {
        assertEquals(
                4,
                FirstBadVersion.findFirstBadVersion(10, version -> version >= 4)
        );
    }

    @Test
    void handlesFirstVersionAlreadyBad() {
        assertEquals(
                1,
                FirstBadVersion.findFirstBadVersion(5, version -> version >= 1)
        );
    }

    @Test
    void handlesOnlyLastVersionBeingBad() {
        assertEquals(
                9,
                FirstBadVersion.findFirstBadVersion(9, version -> version >= 9)
        );
    }

    @Test
    void usesLogarithmicNumberOfPredicateCalls() {
        AtomicInteger calls = new AtomicInteger();
        IntPredicate isBadVersion = version -> {
            calls.incrementAndGet();
            return version >= 63;
        };

        assertEquals(63, FirstBadVersion.findFirstBadVersion(100, isBadVersion));
        assertTrue(calls.get() <= 7);
    }
}
