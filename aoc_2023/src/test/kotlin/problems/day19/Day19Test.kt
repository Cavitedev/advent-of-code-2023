package problems.day19

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day19Test {

    @Test
    fun part1() {
        val partsSorter = PartsSorter(readInput("day19/input"))
        Assertions.assertEquals(446517L, partsSorter.totalRatingNumber())
    }


}