package problems.day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1KtTest {

    @Test
    fun part1() {
        val trebuchet = Trebuchet("day1/input")
        assertEquals(55621, trebuchet.sumEdgeDigits())
    }

    @Test
    fun part2() {
        val trabuchet = TextTrebuchet("day1/input")
        assertEquals(53592, trabuchet.sumEdgeDigits())
    }


}