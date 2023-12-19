package problems.day19.part2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PartRangeTest {

    @Test
    fun totalComb() {
        val partRange = PartRange(listOf(1..1000, 2500..4000), listOf(1..4000), listOf(1..1), listOf(1..3))
        assertEquals(2501L * 4000L * 1L * 3L, partRange.totalComb())
    }
}