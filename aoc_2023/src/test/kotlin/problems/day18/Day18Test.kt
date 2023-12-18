package problems.day18

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day18Test {

    @Test
    fun part1() {
        val lavaTrench = LavaTrench(readInput("day18/input"))
        Assertions.assertEquals(31171L, lavaTrench.filledCellsCount())
    }


}