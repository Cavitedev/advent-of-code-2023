package problems.day19

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class PartsSorterTest {

    lateinit var partsSorter: PartsSorter

    @BeforeEach
    fun setUp() {
        partsSorter = PartsSorter(readInput("day19/it1"))
    }

    @Test
    fun getWorkflows() {
        assertEquals(11, partsSorter.workflows.size)
    }

    @Test
    fun getParts() {
        assertEquals(5, partsSorter.parts.size)
        assertEquals(Part(787, 2655, 1222, 2876), partsSorter.parts.first())
    }

    @Test
    fun acceptedParts() {
        val acceptedParts = partsSorter.acceptedParts()
        assertEquals(3, acceptedParts.size)
    }

    @Test
    fun totalRatingNumber() {
        assertEquals(19114L, partsSorter.totalRatingNumber())
    }
}