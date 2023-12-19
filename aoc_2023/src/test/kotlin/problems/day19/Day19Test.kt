package problems.day19

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.day19.part1.PartsSorter
import problems.day19.part2.PartsSorter2
import problems.utils.readInput

class Day19Test {

    @Test
    fun part1() {
        val partsSorter = PartsSorter(readInput("day19/input"))
        Assertions.assertEquals(446517L, partsSorter.totalRatingNumber())
    }

    @Test
    fun part2() {
        val partsSorter = PartsSorter2(readInput("day19/input"))
        Assertions.assertEquals(130090458884662L, partsSorter.totalRatingNumber())
    }


}