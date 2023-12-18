package problems.day18

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class LavaTrenchTest {

    lateinit var trench: LavaTrench

    @BeforeEach
    fun setUp() {
        trench = LavaTrench(readInput(("day18/it1")))
    }

    @Test
    fun getDigList() {
        assertEquals(14, trench.digList.size)
        assertEquals(DigData(EastTrenchDir.getInstance(), 6, "70c710".toInt(16)), trench.digList[0])
    }

    @Test
    fun setTrenchCells() {
        trench.setTrenchCells()
        assertEquals(38, trench.cells.size)
        assertEquals(true, trench.cells.contains(LavaCell(0, 1, 0)))
        assertEquals(true, trench.cells.contains(LavaCell(1, 0, 0)))
    }

    @Test
    fun fillCellsAndCount() {
        trench.setTrenchCells()
        trench.fillWithEmptyCells()
        assertEquals(62, trench.cells.size)
    }
}