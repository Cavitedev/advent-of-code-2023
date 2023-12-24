package problems.day24

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class HailSimulatorTest {

    lateinit var hailSimulator: HailSimulator

    @BeforeEach
    fun setUp() {
        hailSimulator = HailSimulator(readInput("day24/it1"))
    }

    @Test
    fun getHailstones() {
        assertEquals(5, hailSimulator.hailstones.size)
        assertEquals(
            Hailstone(HailCoordinate(19, 13, 30), HailCoordinate(-2, 1, -2)),
            hailSimulator.hailstones[0]
        )
    }

    @Test
    fun intersections() {
        assertEquals(5, hailSimulator.intersections().size)
    }

    @Test
    fun intersectionsInArea() {
        assertEquals(2, hailSimulator.intersectionsIn2DArea(7, 27).size)
    }
}