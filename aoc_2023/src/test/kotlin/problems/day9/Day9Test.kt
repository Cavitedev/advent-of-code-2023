package problems.day9

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day9Test {

    // 1712182154 too low
    @Test
    fun part1() {
        val instabilitySensor = InstabilitySensor(readInput("day9/input"))
        Assertions.assertEquals(1898776583L, instabilitySensor.sumPredictedNumbers())
    }

//    @Test
//    fun part2() {
//        val desertMap = DesertMap(readInput("day8/input"))
//        Assertions.assertEquals(9177460370549L, desertMap.ghostStepsSolution())
//    }

}