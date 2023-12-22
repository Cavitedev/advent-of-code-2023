package problems.day22

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day22Test {


    @Test
    fun part1() {
        val sandBrickSimulator = SandBrickSimulator(readInput("day22/input"))
        sandBrickSimulator.fallBricks()

        // 454 too high but close
        Assertions.assertEquals(395, sandBrickSimulator.countBricksCanBeDisintegrated())
    }


}