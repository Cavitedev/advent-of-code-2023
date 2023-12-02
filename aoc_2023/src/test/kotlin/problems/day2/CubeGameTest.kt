package problems.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CubeGameTest {

    @Test
    fun possibleGame() {
        val round1 = CubeRound(1, 1, 1)
        val round2 = CubeRound(12, 13, 14)
        val game = CubeGame(1, listOf(round1, round2))
        val possibleGame = game.isPossibleGame(CubeRound(12, 13, 14))
        assertEquals(true, possibleGame)
    }

    @Test
    fun impossibleGame() {
        val round1 = CubeRound(1, 1, 1)
        val round2 = CubeRound(12, 13, 14)
        val round3 = CubeRound(12, 14, 14)
        val game = CubeGame(1, listOf(round1, round2, round3))
        val possibleGame = game.isPossibleGame(CubeRound(12, 13, 14))
        assertEquals(false, possibleGame)
    }
}