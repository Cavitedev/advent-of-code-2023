package problems.day5

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day5Test {

    @Test
    fun part1() {
        val almanac = Almanac.fromLines(readInput("day5/input"))
        Assertions.assertEquals(1181555926, almanac.minLocation())
    }

    @Test
    fun part2() {
        val almanac = RangeAlmanac.fromLines(readInput("day5/input"))
        Assertions.assertEquals(37806486, almanac.minLocation())
    }

}