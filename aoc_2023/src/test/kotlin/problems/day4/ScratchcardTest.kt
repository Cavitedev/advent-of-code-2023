package problems.day4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScratchcardTest {

    @Test
    fun winningNumbers() {
        val data = Scratchcard(2, intArrayOf(13, 32, 20, 16, 61), intArrayOf(61, 30, 68, 82, 17, 32, 24, 19))
        assertEquals(setOf(32, 61), data.playedNumbersWon())
    }
}