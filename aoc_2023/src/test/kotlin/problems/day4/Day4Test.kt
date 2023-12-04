package problems.day4

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day4Test {

    @Test
    fun part1() {
        val scratchcards = Scratchcards.fromLines(readInput("day4/input"))
        Assertions.assertEquals(21485, scratchcards.sumWinningPoints())
    }

    @Test
    fun part2() {
        val scratchcards = Scratchcards.fromLines(readInput("day4/input"))
        Assertions.assertEquals(11024379, scratchcards.sumNumberOfCopies())
    }

}