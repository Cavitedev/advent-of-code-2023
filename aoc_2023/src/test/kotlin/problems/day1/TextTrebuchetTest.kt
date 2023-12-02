package problems.day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TextTrebuchetTest {

    lateinit var trebuchet: Trebuchet

    @BeforeEach
    fun initTrabucher() {
        trebuchet = TextTrebuchet("day1/input_test2")
    }

    @Test
    fun getInputLines() {
        assertEquals(7, trebuchet.inputLines.count())
    }

    @Test
    fun getEdgeDigits() {
        val listNumbers = trebuchet.getEdgeDigits()
        assertEquals(7, listNumbers.count())
        assertEquals(Pair(2, 9), listNumbers.first())
        assertEquals(Pair(8, 3), listNumbers.get(1))
        assertEquals(Pair(1, 4), listNumbers.get(5))
        assertEquals(Pair(7, 6), listNumbers.last())
    }

    @Test
    fun sumEdgeDigits() {
        assertEquals(281, trebuchet.sumEdgeDigits())
    }
}