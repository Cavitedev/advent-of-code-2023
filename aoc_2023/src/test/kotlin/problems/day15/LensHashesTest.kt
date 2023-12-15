package problems.day15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class LensHashesTest {

    lateinit var lensHashes: LensHashes

    @BeforeEach
    fun setUp() {
        lensHashes = LensHashes(readInput("day15/it1"))
    }

    @Test
    fun getSequences() {
        assertEquals(11, lensHashes.sequences.size)
    }

    @Test
    fun sumHashes() {
        assertEquals(1320L, lensHashes.sumHashResults())
    }

    @Test
    fun focusingPower() {
        assertEquals(145L, lensHashes.focusingPower())
    }
}