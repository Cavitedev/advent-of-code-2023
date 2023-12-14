package problems.day14

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day14Test {

    @Test
    fun part1() {
        val parabolicDish = ParabolicDish(readInput("day14/input"))
        parabolicDish.tiltOnce(NorthTiltDirection.getInstance())
        Assertions.assertEquals(106997L, parabolicDish.sumLoad())
    }

    @Test
    fun part2() {
        val parabolicDish = ParabolicDish(readInput("day14/input"))
        parabolicDish.tiltCycles(1000000000L)
        // Higher than 99621
        Assertions.assertEquals(99641L, parabolicDish.sumLoad())
    }

}