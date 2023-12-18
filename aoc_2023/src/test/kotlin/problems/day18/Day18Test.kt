package problems.day18

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day18Test {

    @Test
    fun part1() {
        val lavaTrench = LavaTrench(readInput("day18/input"))
        lavaTrench.setTrenchCells()
        lavaTrench.fillWithEmptyCells()

        Assertions.assertEquals(31171, lavaTrench.cells.size)
    }


}