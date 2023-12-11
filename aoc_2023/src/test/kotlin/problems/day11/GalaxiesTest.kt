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
        galaxies.expand()
        assertEquals(Galaxy(5, 8), galaxies.galaxiesList[3])
    }

    @Test
    fun sumDistances() {
        galaxies.expand()
        assertEquals(374L, galaxies.sumDistances())
    }
}