package problems.day18

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day18Test {

    @Test
    fun part1() {
        val lavaTrench = LavaTrench(readInput("day18/input"))
        // TODO fix it
//        Assertions.assertEquals(31171L, lavaTrench.filledCellsCount())
    }

    @Test
    fun part2() {
        val lavaTrench = LavaTrenchHex(readInput("day18/input"))
        Assertions.assertEquals(131431655002266L, lavaTrench.filledCellsCount())
    }


    @Test
    fun getWallsToLeft() {
        val trench = LavaTrench(readInput("day18/input"))
        Assertions.assertEquals(2, trench.getWallsToLeft(trench.enhancedDigData(), -52, 22).size)
    }

}