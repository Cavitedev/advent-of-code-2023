package problems.day24

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day24Test {


    @Test
    fun part1() {
        val hail = HailSimulator(readInput("day24/input"))
        // 350 too low
        Assertions.assertEquals(2202, hail.intersectionsIn2DArea(200000000000000, 400000000000000).size)
    }


}