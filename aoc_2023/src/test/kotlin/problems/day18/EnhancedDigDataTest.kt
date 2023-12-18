package problems.day18

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EnhancedDigDataTest {

    @Test
    fun isInRowNorth() {

        val dig = EnhancedDigData(5, 2, DigData(NorthTrenchDir.getInstance(), 9))

        assertEquals(false, dig.isInRow(-4))
        assertEquals(true, dig.isInRow(-3))
        assertEquals(true, dig.isInRow(5))
        assertEquals(false, dig.isInRow(6))

    }

    @Test
    fun isInRowSouth() {

        val dig = EnhancedDigData(-3, 2, DigData(SouthTrenchDir.getInstance(), 9))

        assertEquals(false, dig.isInRow(-4))
        assertEquals(true, dig.isInRow(-3))
        assertEquals(true, dig.isInRow(5))
        assertEquals(false, dig.isInRow(6))

    }
}