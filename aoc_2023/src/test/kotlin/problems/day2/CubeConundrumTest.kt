package problems.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import problems.utils.readInput

class CubeConundrumTest {

    lateinit var cubeConundrum: CubeConundrum

    @BeforeEach
    fun beforeEach() {
        cubeConundrum = CubeConundrum.fromLines(readInput("day2/input_test"))
    }

    @Test
    fun getGames() {
        assertEquals(5, cubeConundrum.games.count())
    }


    @Test
    fun sumIdPossibleGames() {
        assertEquals(8, cubeConundrum.sumIdPossibleGames(CubeRound(12, 13, 14)))
    }
}