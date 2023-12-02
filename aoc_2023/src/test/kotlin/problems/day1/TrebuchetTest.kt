package problems.day1


import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested

class TrebuchetTest {

    @Nested
    @DisplayName("Part 1")
    inner class Part1TrebuchetTest {

        lateinit var trebuchet: Trebuchet

        @BeforeEach
        fun initTrabucher() {
            trebuchet = Trebuchet("day1/input_test")
        }

        @Test
        fun getInputLines() {
            assertEquals(4, trebuchet.inputLines.count())

        }

        @Test
        fun getEdgeDigits() {
            assertEquals(4, trebuchet.getEdgeDigits().count())
        }

        @Test
        fun sumEdgeDigits() {
            assertEquals(142, trebuchet.sumEdgeDigits())
        }
    }
}