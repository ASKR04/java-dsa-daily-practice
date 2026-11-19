package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class PartitionLabelsTest {
    @Test
    void createsMaximumNumberOfValidPartitions() {
        assertEquals(
                List.of(9, 7, 8),
                PartitionLabels.partitionSizes(
                        "ababcbacadefegdehijhklij"));
    }

    @Test
    void keepsOverlappingCharacterRangesTogether() {
        assertEquals(
                List.of(10),
                PartitionLabels.partitionSizes("eccbbbbdec"));
    }

    @Test
    void handlesEmptyUniqueAndRepeatedCharacters() {
        assertEquals(List.of(), PartitionLabels.partitionSizes(""));
        assertEquals(List.of(1, 1, 1), PartitionLabels.partitionSizes("abc"));
        assertEquals(List.of(4), PartitionLabels.partitionSizes("aaaa"));
    }

    @Test
    void supportsCharactersBeyondLowercaseLetters() {
        assertEquals(
                List.of(3, 1),
                PartitionLabels.partitionSizes("A1A!"));
    }

    @Test
    void rejectsNullInput() {
        assertThrows(
                NullPointerException.class,
                () -> PartitionLabels.partitionSizes(null));
    }
}
