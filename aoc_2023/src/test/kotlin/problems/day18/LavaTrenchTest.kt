package problems.day18

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class
LavaTrenchTest {

    lateinit var trench: LavaTrench

    @BeforeEach
    fun setUp() {
        trench = LavaTrench(readInput(("day18/it1")))
    }

    @Test
    fun getDigList() {
        assertEquals(14, trench.digList.size)
        assertEquals(DigData(EastTrenchDir.getInstance(), 6), trench.digList[0])
    }



    @Test
    fun fillCellsAndCount() {
        assertEquals(62L, trench.filledCellsCount())
    }


    @Test
    fun printInput() {
        trench.printInput()
    }
}