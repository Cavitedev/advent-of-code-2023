package problems.day22

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class SandBrickSimulatorRealInput {
    lateinit var sandBrickSimulator: SandBrickSimulator

    @BeforeEach
    fun setUp() {
        sandBrickSimulator = SandBrickSimulator(readInput("day22/input"))
    }

    @Test
    fun aboveBricksContainDownBricks() {
        sandBrickSimulator.fallBricks()
        Assertions.assertEquals(true, sandBrickSimulator.bricks.all {
            it.aboveBricks.all { above ->
                above.downBricks.contains(it)
            }
        })
    }
}