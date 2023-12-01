package problems.day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TextTrabuchetTest {

    lateinit var trabuchet: Trabuchet

    @BeforeEach
    fun initTrabucher() {
        trabuchet = TextTrabuchet("test/resources/problems/day1/input_test2")
    }

    @Test
    fun getInputLines() {
        assertEquals(7, trabuchet.inputLines.count())
    }

    @Test
    fun getNumberLines() {
        val listNumbers = trabuchet.getNumberLines()
        assertEquals(7, listNumbers.count())
        assertEquals(listOf(2, 1, 9), listNumbers.first())
        assertEquals(listOf(8, 2, 3), listNumbers.get(1))
        assertEquals(listOf(1, 8, 2, 3, 4), listNumbers.get(5))
        assertEquals(listOf(7, 6), listNumbers.last())
    }

    @Test
    fun sumEdgeDigits() {
        assertEquals(281, trabuchet.sumEdgeDigits())
    }
}