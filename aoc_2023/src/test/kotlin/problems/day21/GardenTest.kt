package problems.day21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class GardenTest {

    lateinit var garden: Garden

    @BeforeEach
    fun setUp() {
        garden = Garden(readInput("day21/it1"))
    }

    @Test
    fun getCells() {
        assertEquals(11, garden.cells.size)
        assertEquals(true, garden.cells[2][1] is GardenWallCell)
        assertEquals(true, garden.cells[2][0] is GardenPlotCell)
        assertEquals(Pair(5, 5), garden.startPos)
    }

    @Test
    fun countPlotsAtStep() {
        garden.search()
        assertEquals(16, garden.countPlotsAtStep(6))
    }
}