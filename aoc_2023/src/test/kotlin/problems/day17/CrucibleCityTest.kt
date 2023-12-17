package problems.day17

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class CrucibleCityTest {

    lateinit var city: CrucibleCity

    @BeforeEach
    fun setUp() {
        city = CrucibleCity(readInput("day17/it1"))
    }

    @Test
    fun getGrid() {
        assertEquals(13, city.grid.size)
        assertEquals(listOf(2, 4, 1, 3, 4, 3, 2, 3, 1, 1, 3, 2, 3), city.grid[0])
    }

    @Test
    fun minimumHeatLoss() {
        assertEquals(102, city.minimumHeastLoss())
    }

    @Test
    fun minimumHeatLossUltraCrucible() {
        assertEquals(94, city.minimumHeastLossUltraCrucible())
    }
}