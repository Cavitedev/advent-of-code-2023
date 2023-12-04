package problems.day4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class ScratchcardsTest {

    lateinit var scratchcards: Scratchcards

    @BeforeEach
    fun setupScratchcards() {
        scratchcards = Scratchcards.fromLines(readInput("day4/input_test"))
    }

    @Test
    fun rightNumberOfGames() {
        assertEquals(6, scratchcards.scratchcards.count())
    }

    @Test
    fun game2IsCorrect() {
        val game2 = Scratchcard(2, intArrayOf(13, 32, 20, 16, 61), intArrayOf(61, 30, 68, 82, 17, 32, 24, 19))
        assertEquals(game2.winningNumbers.toList(), scratchcards.scratchcards[1].winningNumbers.toList())
    }

    @Test
    fun sumWinningPoints() {
        assertEquals(13, scratchcards.sumWinningPoints())
    }

    @Test
    fun sumWinningPointsThroughCopies() {
        assertEquals(30, scratchcards.sumNumberOfCopies())
    }
}