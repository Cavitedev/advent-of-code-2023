package problems.day2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day2Test {

    @Test
    fun part1() {
        val conundrum = CubeConundrum.fromLines(readInput("day2/input"))
        Assertions.assertEquals(2239, conundrum.sumIdPossibleGames(CubeRound(12, 13, 14)))
    }

    @Test
    fun part2() {
        val conundrum = CubeConundrum.fromLines(readInput("day2/input"))
        Assertions.assertEquals(83435, conundrum.sumPowersMinimumSets())
    }

}