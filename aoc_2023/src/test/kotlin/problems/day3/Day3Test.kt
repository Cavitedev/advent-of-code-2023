package problems.day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day3Test {
    @Test
    fun part1() {
        val gondola = Gondola.fromLines(readInput("day3/input"))
        Assertions.assertEquals(532445, gondola.sumValues())
    }

    @Test
    fun part2() {
        val gondola = Gondola.fromLines(readInput("day3/input"))
        Assertions.assertEquals(79842967, gondola.gearRatio())
    }
}