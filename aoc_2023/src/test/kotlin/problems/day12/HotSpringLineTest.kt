package problems.day12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HotSpringLineTest {

    @Test
    fun arrangementsCountSimplest() {
        val line = HotSpringLine("###", listOf(3))
        assertEquals(1L, line.arrangementsCount())
    }

    @Test
    fun arrangementsCountSimpleWithAddition() {
        val line = HotSpringLine("###", listOf(1, 3))
        assertEquals(0L, line.arrangementsCount())
    }

    @Test
    fun arrangementsCount() {
        val line = HotSpringLine("???.###", listOf(1, 1, 3))
        assertEquals(1L, line.arrangementsCount())
    }

    @Test
    fun arrangementsCount2() {
        val line = HotSpringLine(".??..??...?##.", listOf(1, 1, 3))
        assertEquals(4L, line.arrangementsCount())
    }

    @Test
    fun arrangementsCount3() {
        val line = HotSpringLine("?#?#?#?#?#?#?#?", listOf(1, 3, 1, 6))
        assertEquals(1L, line.arrangementsCount())
    }

    @Test
    fun arrangementsCount4() {
        val line = HotSpringLine("????.#...#...", listOf(4, 1, 1))
        assertEquals(1L, line.arrangementsCount())
    }

    @Test
    fun arrangementsCount5() {
        val line = HotSpringLine("????.######..#####.", listOf(1, 6, 5))
        assertEquals(4L, line.arrangementsCount())
    }

    @Test
    fun arrangementsCount6() {
        val line = HotSpringLine("?###????????", listOf(3, 2, 1))
        assertEquals(10L, line.arrangementsCount())
    }
}