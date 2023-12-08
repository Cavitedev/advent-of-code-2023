package problems.day8

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day8Test {

    @Test
    fun part1() {
        val desertMap = DesertMap(readInput("day8/input"))
        Assertions.assertEquals(19783, desertMap.stepsSolution())
    }

    @Test
    fun part2() {
        val desertMap = DesertMap(readInput("day8/input"))
        Assertions.assertEquals(9177460370549L, desertMap.ghostStepsSolution())
    }

}