package problems.utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FileReaderKtTest {

    @Test
    fun readInput() {
        val lines: List<String> = readInput("test/resources/problems/day1/input_test")
        assertEquals(listOf("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"), lines)
    }
}