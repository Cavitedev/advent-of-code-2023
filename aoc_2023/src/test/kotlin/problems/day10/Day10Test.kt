package problems.day10

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day10Test {


    @Test
    fun part1() {
        val pipeMaze = PipeMaze(readInput("day10/input"))
        Assertions.assertEquals(6870, pipeMaze.furtherstDistanceNode())
    }


    @Test
    fun part2() {
        val pipeMaze = PipeMaze(readInput("day10/input"))
        Assertions.assertEquals(287, pipeMaze.innerTilesCount())
    }

}