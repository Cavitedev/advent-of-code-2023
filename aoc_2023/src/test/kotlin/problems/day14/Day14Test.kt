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

}