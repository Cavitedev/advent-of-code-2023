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

    @Test
    fun convertRangeOutOfBoundariesReturnsSameList() {
        val convertRange = ConvertRange(40, 60, 5)
        assertEquals(listOf(Pair(80L, 90L)), convertRange.convert(listOf(Pair(80L, 90L))).flatten())
    }


    @Test
    fun convertRangeBothInBoundariesReturnsTransformedList() {
        val convertRange = ConvertRange(80, 60, 11)
        assertEquals(listOf(Pair(60L, 70L)), convertRange.convert(listOf(Pair(80L, 90L))).flatten())
    }

    @Test
    fun convertRangeOutOfBondariesStartReturnTwoRightPairs() {
        val convertRange = ConvertRange(80, 60, 11)
        assertEquals(
            listOf(Pair(75L, 79L), Pair(60L, 65L)).toSet(),
            convertRange.convert(listOf(Pair(75L, 85L))).flatten().toSet()
        )
    }

    @Test
    fun convertRangeOutOfBondariesEndReturnTwoRightPairs() {
        val convertRange = ConvertRange(80, 60, 11)
        assertEquals(
            listOf(Pair(91L, 95L), Pair(65L, 70L)).toSet(),
            convertRange.convert(listOf(Pair(85L, 95L))).flatten().toSet()
        )
    }

    @Test
    fun convertRangeOutOfBothBondariesReturnThreeRightPairs() {
        val convertRange = ConvertRange(80, 60, 11)
        assertEquals(
            listOf(Pair(75L, 79L), Pair(91L, 95L), Pair(60L, 70L)).toSet(),
            convertRange.convert(listOf(Pair(75L, 95L))).flatten().toSet()
        )
    }

    @Test
    fun convertRangeLimitBondary() {
        val convertRange = ConvertRange(25, 18, 70)
        assertEquals(
            listOf(Pair(44L, 49L), Pair(54L, 60L), Pair(74L, 87L)).toSet(),
            convertRange.convert(listOf(Pair(81L, 94L), Pair(51L, 56L), Pair(61L, 67L))).flatten().toSet()
        )
    }

}