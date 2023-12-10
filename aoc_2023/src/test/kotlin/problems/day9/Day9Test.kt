package problems.day9

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day9Test {


    @Test
    fun part1() {
        val instabilitySensor = InstabilitySensor(readInput("day9/input"))
        Assertions.assertEquals(1898776583L, instabilitySensor.sumExtrapolatedForwardNumbers())
    }


    @Test
    fun part2() {
        val instabilitySensor = InstabilitySensor(readInput("day9/input"))
        Assertions.assertEquals(1100L, instabilitySensor.sumExtrapolatedBackwardNumbers())
    }

}