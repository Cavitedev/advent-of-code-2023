package problems.day24

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day24Test {


    @Test
    fun part1() {
        val hail = HailSimulator(readInput("day24/input"))
        Assertions.assertEquals(
            24627,
            hail.intersectionsIn2DArea(200000000000000.toBigDecimal(), 400000000000000.toBigDecimal()).size
        )
    }

    @Test
    fun part2() {
        val hail = HailSimulator(readInput("day24/input"))
        val result = hail.resolveEquations()
        Assertions.assertEquals(527310134398221, result!!.pos.total().toLong())
    }


}