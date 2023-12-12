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

    @Test
    fun foldSimple() {
        val line = HotSpringLine(".#", listOf(1))
        line.fold()
        assertEquals(HotSpringLine(".#?.#?.#?.#?.#", listOf(1, 1, 1, 1, 1)), line)
    }

    @Test
    fun foldComplex() {
        val line = HotSpringLine("???.###", listOf(1, 1, 3))
        line.fold()
        assertEquals(
            HotSpringLine(
                "???.###????.###????.###????.###????.###",
                listOf(1, 1, 3, 1, 1, 3, 1, 1, 3, 1, 1, 3, 1, 1, 3)
            ), line
        )
    }

    @Test
    fun arrangementsFold1() {
        val line = HotSpringLine("?????.????????????", listOf(4, 1, 1, 6))
        line.fold()
        assertEquals(139629908L, line.arrangementsCount())
    }


    @Test
    fun arrangementsFold6() {
        val line = HotSpringLine("?###????????", listOf(3, 2, 1))
        line.fold()
        assertEquals(506250L, line.arrangementsCount())
    }

//    @Test
//    fun arrangementsFoldSlow() {
//        val line = HotSpringLine("?#??????????#????##", listOf(2, 1, 1, 3, 2, 4))
//        line.fold()
//        assertEquals(14406L, line.arrangementsCount())
//    }
//
//    @Test
//    fun arrangementsFolded2_1() {
//        val line = HotSpringLine("???.###", listOf(1, 1, 3))
//        assertEquals(1L, line.arrangementsCountFolded())
//    }
//
//    @Test
//    fun arrangementsFolded2_2() {
//        val line = HotSpringLine(".??..??...?##.", listOf(1, 1, 3))
//        assertEquals(16384L, line.arrangementsCountFolded())
//    }
//
//    @Test
//    fun arrangementsFolded2_3() {
//        val line = HotSpringLine("?#?#?#?#?#?#?#?", listOf(1, 3, 1, 6))
//        assertEquals(1L, line.arrangementsCountFolded())
//    }
//
//    @Test
//    fun arrangementsFolded2_4() {
//        val line = HotSpringLine("????.#...#...", listOf(4, 1, 1))
//        assertEquals(16L, line.arrangementsCountFolded())
//    }
//
//    @Test
//    fun arrangementsFolded2_5() {
//        val line = HotSpringLine("????.######..#####.", listOf(1, 6, 5))
//        assertEquals(2500L, line.arrangementsCountFolded())
//    }
//
//    @Test
//    fun arrangementsFolded2_6() {
//        val line = HotSpringLine("?###????????", listOf(3, 2, 1))
//        assertEquals(506250L, line.arrangementsCountFolded())
//    }
}