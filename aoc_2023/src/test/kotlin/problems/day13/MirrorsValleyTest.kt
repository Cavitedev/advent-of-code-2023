package problems.day13

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class MirrorsValleyTest {

    lateinit var mirrorsValley: MirrorsValley

    @BeforeEach
    fun setUp() {
        mirrorsValley = MirrorsValley(readInput("day13/it1"))
    }

    @Test
    fun getPatterns() {
        assertEquals(2, mirrorsValley.patterns.size)
        assertEquals(7, mirrorsValley.patterns[0].pattern.size)
        assertEquals(9, mirrorsValley.patterns[0].pattern[0].size)
        assertEquals("#.##..##.".toList(), mirrorsValley.patterns[0].pattern[0])
    }

    @Test
    fun mirrorRows() {
        assertEquals(null, mirrorsValley.patterns[0].mirrorRow())
        assertEquals(4, mirrorsValley.patterns[1].mirrorRow())
    }

    @Test
    fun mirrorCol() {
        assertEquals(5, mirrorsValley.patterns[0].mirrorCol())
        assertEquals(null, mirrorsValley.patterns[1].mirrorCol())
    }

    @Test
    fun sumMirrors() {
        assertEquals(405L, mirrorsValley.sumMirrors())
    }
}