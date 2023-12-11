package problems.day11

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class GalaxiesTest {

    lateinit var galaxies: Galaxies

    @BeforeEach
    fun setUp() {
        galaxies = Galaxies(readInput("day11/input_test"))
    }

    @Test
    fun getGalaxies() {
        assertEquals(9, galaxies.galaxiesList.size)
    }

    @Test
    fun expandGalaxies() {
        assertEquals(Galaxy(4, 6), galaxies.galaxiesList[3])
        galaxies.expand(1)
        assertEquals(Galaxy(5, 8), galaxies.galaxiesList[3])
    }

    @Test
    fun sumDistances() {
        galaxies.expand(1)
        assertEquals(374L, galaxies.sumDistances())
    }

    @Test
    fun sumDistanceExpand10() {
        galaxies.expand(9)
        assertEquals(1030L, galaxies.sumDistances())
    }

    @Test
    fun sumDistanceExpand100() {
        galaxies.expand(99)
        assertEquals(8410L, galaxies.sumDistances())
    }
}