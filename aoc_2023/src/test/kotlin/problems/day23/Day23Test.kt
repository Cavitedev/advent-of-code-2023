package problems.day23

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day23Test {


    @Test
    fun part1() {
        val hikingMap = HikingMap(readInput("day23/input"))
        Assertions.assertEquals(2202, hikingMap.longestPath())
    }


    @Test
    fun part2() {
        val hikingMap = HikingMap(readInput("day23/input"))
        hikingMap.removeSlopes()
        Assertions.assertEquals(2202, hikingMap.longestPath())
    }


}