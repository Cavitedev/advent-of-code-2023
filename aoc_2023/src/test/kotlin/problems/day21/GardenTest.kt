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


    @Test
    fun countBySections() {
        garden.repeat(10)
        garden.search()
        for (n in 0..100L) {
            val total = garden.countPlotsAtStep(n)
            println("n=$n, total= $total")
            println(garden.countBySections(n).map { it.map { num -> String.format("%${2}d", num) } }.joinToString("\n"))
        }
//        val n = 31L

    }


    @Test
    fun countRepeatedMap() {
        garden.repeat(3)
        garden.search()
        assertEquals(16, garden.countPlotsOptimizedAtStep(6))
        assertEquals(50, garden.countPlotsOptimizedAtStep(10))
        // 1447 + 65  + 52 + 0 + 0 = 1594
        assertEquals(1594, garden.countPlotsOptimizedAtStep(50))

        //// 1986 + 154 + 946 + 648 + 2802 = 6536
        assertEquals(6536, garden.countPlotsOptimizedAtStep(100))
        assertEquals(167004, garden.countPlotsOptimizedAtStep(500))
        assertEquals(668697, garden.countPlotsOptimizedAtStep(1000))
        assertEquals(16733044, garden.countPlotsOptimizedAtStep(5000))

    }


}