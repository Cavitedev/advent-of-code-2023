package problems.day5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConvertRangeTest {

    @Test
    fun convertNotInRangeReturnsNull() {
        val convertRange = ConvertRange(40, 60, 5)
        assertEquals(null, convertRange.convert(39))
        assertEquals(null, convertRange.convert(45))
    }

    @Test
    fun convertInRangeConvertsValue() {
        val convertRange = ConvertRange(40, 60, 5)
        assertEquals(60, convertRange.convert(40))
        assertEquals(64, convertRange.convert(44))
        assertEquals(62, convertRange.convert(42))
    }
}