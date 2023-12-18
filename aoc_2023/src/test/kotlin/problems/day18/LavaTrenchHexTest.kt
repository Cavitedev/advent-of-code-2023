package problems.day18

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class LavaTrenchHexTest {

    lateinit var trench: LavaTrenchHex

    @BeforeEach
    fun setUp() {
        trench = LavaTrenchHex(readInput("day18/it1"))
    }

    @Test
    fun getDigList() {
        assertEquals(14, trench.digList.size)
        assertEquals(DigData(EastTrenchDir.getInstance(), 461937), trench.digList[0])
    }

    @Test
    fun fillCellsAndCount() {
        assertEquals(952408144115L, trench.filledCellsCount())
    }
}