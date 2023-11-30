package problems.utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FileReaderKtTest {

    @Test
    fun readInput() {
        val lines: List<String> = problems.utils.readInput("test/resources/problems/day1/input")
        assertEquals(lines, listOf("abc"));
    }
}