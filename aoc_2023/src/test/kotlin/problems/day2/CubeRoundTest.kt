package problems.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

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
}