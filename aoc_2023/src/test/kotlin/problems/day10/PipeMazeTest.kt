package problems.day10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class PipeMazeTest {

    lateinit var pipeMaze: PipeMaze

    @BeforeEach
    fun setUp() {
        pipeMaze = PipeMaze(readInput("day10/input_test"))
    }

    @Test
    fun getMaze() {
        assertEquals(5, pipeMaze.maze.size)
        assertEquals(5, pipeMaze.maze[0].size)
    }

    @Test
    fun getNeighbours() {
        val startPipe = pipeMaze.startPipe
        assertEquals(2, startPipe.findNeighbours(pipeMaze).count())
    }

    @Test
    fun furthestDistanceNode() {
        assertEquals(8, pipeMaze.furtherstDistanceNode())
    }
}