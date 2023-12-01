package problems.day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1KtTest {

    @Test
    fun part1() {
        val trabuchet = Trabuchet("test/resources/problems/day1/input")
        assertEquals(55621, trabuchet.sumEdgeDigits())
    }

    @Test
    fun part2() {
        val trabuchet = TextTrabuchet("test/resources/problems/day1/input")
        assertEquals(53592, trabuchet.sumEdgeDigits())
    }


}