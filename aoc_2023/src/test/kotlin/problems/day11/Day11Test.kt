package problems.day11

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day11Test {


    @Test
    fun part1() {
        val galaxies = Galaxies(readInput("day11/input"))
        galaxies.expand()
        Assertions.assertEquals(9918828L, galaxies.sumDistances())
    }


//    @Test
//    fun part2() {
//        val pipeMaze = PipeMaze(readInput("day10/input"))
//        Assertions.assertEquals(287, pipeMaze.innerTilesCount())
//    }

}