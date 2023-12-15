package problems.day15

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day15Test {

    @Test
    fun part1() {
        val lensHashes = LensHashes(readInput("day15/input"))
        Assertions.assertEquals(498538L, lensHashes.sumHashResults())
    }


}