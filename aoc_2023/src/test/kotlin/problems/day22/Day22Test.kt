package problems.day22

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day22Test {


    @Test
    fun part1() {
        val sandBrickSimulator = SandBrickSimulator(readInput("day22/input"))
        sandBrickSimulator.fallBricks()
        Assertions.assertEquals(395, sandBrickSimulator.countBricksCanBeDisintegrated())
    }

    @Test
    fun part2() {
        val sandBrickSimulator = SandBrickSimulator(readInput("day22/input"))
        sandBrickSimulator.fallBricks()
        Assertions.assertEquals(64714, sandBrickSimulator.sumFallIfDisintegrate())
    }


}