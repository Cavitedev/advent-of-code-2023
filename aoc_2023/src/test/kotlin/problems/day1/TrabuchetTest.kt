package problems.day1


import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested

class TrabuchetTest {

    @Nested
    @DisplayName("Part 1")
    inner class Part1TrabuchetTest {

        lateinit var trabuchet: Trabuchet

        @BeforeEach
        fun initTrabucher() {
            trabuchet = Trabuchet("test/resources/problems/day1/input_test")
        }

        @Test
        fun getInputLines() {
            assertEquals(4, trabuchet.inputLines.count())

        }

        @Test
        fun getNumberLines() {
            assertEquals(4, trabuchet.getNumberLines().count())
        }

        @Test
        fun sumEdgeDigits() {
            assertEquals(142, trabuchet.sumEdgeDigits())
        }
    }
}