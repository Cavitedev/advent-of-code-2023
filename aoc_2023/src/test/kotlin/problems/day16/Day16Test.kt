package problems.day16

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day16Test {

    @Test
    fun part1() {
        val mirrorCave = MirrorCave(readInput("day16/input"))
        Assertions.assertEquals(7623, mirrorCave.energizedBeansTopLeft())
    }

    @Test
    fun part2() {
        val mirrorCave = MirrorCave(readInput("day16/input"))
        Assertions.assertEquals(8244, mirrorCave.bestEnergizedBeanAllDirs())
    }

}