package problems.day7

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day7Test {

    @Test
    fun part1() {
        val game = CamelCardGame(readInput("day7/input"))
        Assertions.assertEquals(249204891, game.totalBettings())
    }

    @Test
    fun part2() {
        val game = CamelCardGameJoker(readInput("day7/input"))
        Assertions.assertEquals(249666369, game.totalBettings())
    }
}