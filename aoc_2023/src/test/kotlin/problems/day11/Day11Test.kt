package problems.day11

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day11Test {


    @Test
    fun part1() {
        val galaxies = Galaxies(readInput("day11/input"))
        galaxies.expand(1)
        Assertions.assertEquals(9918828L, galaxies.sumDistances())
    }


    @Test
    fun part2() {
        val galaxies = Galaxies(readInput("day11/input"))
        galaxies.expand(999999)
        Assertions.assertEquals(692506533832L, galaxies.sumDistances())
    }

}