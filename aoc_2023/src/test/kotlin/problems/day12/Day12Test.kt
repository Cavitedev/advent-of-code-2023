package problems.day12

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day12Test {


    @Test
    fun part1() {
        val springsGroup = HotSpringsGroup(readInput("day12/input"))
        Assertions.assertEquals(7622L, springsGroup.sumArrangementsCount())
    }

    @Test
    fun part2() {
        val springsGroup = HotSpringsGroup(readInput("day12/input"))
        springsGroup.foldLines()
        Assertions.assertEquals(4964259839627L, springsGroup.sumArrangementsCount())
    }


}