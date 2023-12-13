package problems.day13

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day13Test {


    @Test
    fun part1() {
        val mirrorsValley = MirrorsValley(readInput("day13/input"))
        Assertions.assertEquals(37975L, mirrorsValley.sumMirrors())
    }


}