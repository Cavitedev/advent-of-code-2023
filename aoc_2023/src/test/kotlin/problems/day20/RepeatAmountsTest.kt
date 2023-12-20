package problems.day20

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RepeatAmountsTest {


    @Test
    fun toPatternTrueFalse() {
        val repeatAmount = RepeatAmounts(
            mutableListOf(
                RepeatAmount(true, 1),
                RepeatAmount(false, 1),
                RepeatAmount(true, 1),
                RepeatAmount(false, 1),
                RepeatAmount(true, 1),
                RepeatAmount(false, 1),
            )
        )
        val pattern = repeatAmount.toPattern()
        val expected = PulsePattern(listOf(0L..0), 2)
        assertEquals(expected, pattern)
    }

    @Test
    fun toPattern() {
        val repeatAmount = RepeatAmounts(
            mutableListOf(
                RepeatAmount(true, 1),
                RepeatAmount(false, 2),
                RepeatAmount(true, 2),
                RepeatAmount(false, 4),
                RepeatAmount(true, 2),
                RepeatAmount(false, 2),
                RepeatAmount(true, 2),
                RepeatAmount(false, 4),
                RepeatAmount(true, 2),
            )
        )
        val pattern = repeatAmount.toPattern()
        val expected = PulsePattern(listOf(3L..4, 9L..9, 0L..0), 10)
        assertEquals(expected, pattern)
    }
}