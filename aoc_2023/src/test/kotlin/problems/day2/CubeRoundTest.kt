package problems.day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CubeRoundTest {

    @Test
    fun possibleRound() {
        val cubeRound = CubeRound(12, 13, 14)
        val possibleRound = cubeRound.possibleRound(CubeRound(12, 13, 14))
        assertEquals(possibleRound, true)
    }

    @Test
    fun impossibleRoundRed() {
        val cubeRound = CubeRound(13, 13, 14)
        val possibleRound = cubeRound.possibleRound(CubeRound(12, 13, 14))
        assertEquals(possibleRound, false)
    }

    @Test
    fun impossibleRoundGreen() {
        val cubeRound = CubeRound(12, 14, 14)
        val possibleRound = cubeRound.possibleRound(CubeRound(12, 13, 14))
        assertEquals(possibleRound, false)
    }

    @Test
    fun impossibleRoundBlue() {
        val cubeRound = CubeRound(12, 13, 15)
        val possibleRound = cubeRound.possibleRound(CubeRound(12, 13, 14))
        assertEquals(possibleRound, false)
    }

    @Test
    fun powerSet() {
        val cubeRound = CubeRound(12, 13, 15)
        val powerSet = cubeRound.powerSet()
        assertEquals(12 * 13 * 15, powerSet)
    }

    @Test
    fun minimumSet() {
        val cube1 = CubeRound(1, 2, 3)
        val cube2 = CubeRound(3, 2, 1)
        val minCube = cube1.combineMinimumSet(cube2)
        assertEquals(minCube, CubeRound(3, 2, 3))
    }
}