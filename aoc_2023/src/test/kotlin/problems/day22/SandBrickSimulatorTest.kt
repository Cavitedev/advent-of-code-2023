package problems.day22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class SandBrickSimulatorTest {

    lateinit var sandBrickSimulator: SandBrickSimulator

    @BeforeEach
    fun setUp() {
        sandBrickSimulator = SandBrickSimulator(readInput("day22/it1"))
    }

    @Test
    fun getBricks() {
        assertEquals(7, sandBrickSimulator.bricks.size)
        assertEquals(Coordinate(1, 2, 1), sandBrickSimulator.bricks[0].endCoordinate)
    }

    @Test
    fun aboveBricksContainDownBricks() {
        sandBrickSimulator.fallBricks()
        assertEquals(true, sandBrickSimulator.bricks.all {
            it.aboveBricks.all { above ->
                above.downBricks.contains(it)
            }
        })
    }

    @Test
    fun countBricksCanBeDisintegrated() {
        sandBrickSimulator.fallBricks()
        assertEquals(5, sandBrickSimulator.countBricksCanBeDisintegrated())
    }


}