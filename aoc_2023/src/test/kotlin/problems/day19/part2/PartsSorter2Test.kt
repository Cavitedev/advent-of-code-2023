package problems.day19.part2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class PartsSorter2Test {

    lateinit var partsSorter: PartsSorter2

    @BeforeEach
    fun setUp() {
        partsSorter = PartsSorter2(readInput("day19/it1"))
    }

    @Test
    fun totalRatingNumber() {
        assertEquals(167409079868000L, partsSorter.totalRatingNumber())
    }
}