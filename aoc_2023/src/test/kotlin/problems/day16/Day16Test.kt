package problems.day16

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day16Test {

    @Test
    fun part1() {
        val mirrorCave = MirrorCave(readInput("day16/input"))
        Assertions.assertEquals(498538, mirrorCave.energizedBeansTopLeft())
    }


}