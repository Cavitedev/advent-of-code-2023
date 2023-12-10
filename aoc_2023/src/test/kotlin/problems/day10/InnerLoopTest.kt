package problems.day10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import problems.utils.readInput

class InnerLoopTest {

    @Test
    fun case1InnerTilesAreRight() {
        val maze = PipeMaze(readInput("day10/t_1"))
        assertEquals(4, maze.innerTilesCount())
    }

    @Test
    fun case2InnerTilesAreRight() {
        val maze = PipeMaze(readInput("day10/t_2"))
        assertEquals(4, maze.innerTilesCount())
    }

    @Test
    fun case3InnerTilesAreRight() {
        val maze = PipeMaze(readInput("day10/t_3"))
        assertEquals(8, maze.innerTilesCount())
    }

    @Test
    fun case4InnerTilesAreRight() {
        val maze = PipeMaze(readInput("day10/t_4"))
        assertEquals(10, maze.innerTilesCount())
    }


}