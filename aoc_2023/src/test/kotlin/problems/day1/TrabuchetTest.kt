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

//        @Test
//        fun getNumberLines() {
//            assertEquals(4, trabuchet.getNumberLines().count());
//        }

        @Test
        fun sumEdgeDigits() {
            assertEquals(142, trabuchet.sumEdgeDigits())
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2TrabuchetTest {

        lateinit var trabuchet: Trabuchet

        @BeforeEach
        fun initTrabucher() {
            trabuchet = Trabuchet("test/resources/problems/day1/input_test2")
        }

        @Test
        fun getInputLines() {
            assertEquals(7, trabuchet.inputLines.count())
        }

        @Test
        fun getNumberLines() {
            val listNumbers = trabuchet.getNumberLines(true)
            assertEquals(7, listNumbers.count())
            assertEquals(listOf(2, 1, 9), listNumbers.first())
            assertEquals(listOf(8, 2, 3), listNumbers.get(1))
            assertEquals(listOf(1, 8, 2, 3, 4), listNumbers.get(5))
            assertEquals(listOf(7, 6), listNumbers.last())
        }

        @Test
        fun sumEdgeDigits() {
            assertEquals(281, trabuchet.sumEdgeDigits(true))
        }
    }

}