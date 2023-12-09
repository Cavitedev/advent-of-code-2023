package problems.day9

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SensorLineTest {

    @Test
    fun predictNextNumber() {
        val line = SensorLine(listOf(10L, 13L, 16L, 21L, 30L, 45L))
        assertEquals(68L, line.predictNextNumber())
    }
}