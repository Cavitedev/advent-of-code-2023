package problems.day12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class HotSpringsGroupTest {

    lateinit var hotSpringsGroup: HotSpringsGroup

    @BeforeEach
    fun setUp() {
        hotSpringsGroup = HotSpringsGroup(readInput("day12/it1"))
    }

    @Test
    fun getSpringLines() {
        assertEquals(6, hotSpringsGroup.springLines.size)
        assertEquals(HotSpringLine("???.###", listOf(1, 1, 3)), hotSpringsGroup.springLines.first())
    }

    @Test
    fun sumArrangementsCount() {
        assertEquals(21L, hotSpringsGroup.sumArrangementsCount())
    }

    @Test
    fun sumArrangementsCountFolded() {
        this.hotSpringsGroup.foldLines()
        assertEquals(525152L, hotSpringsGroup.sumArrangementsCount())
    }
}