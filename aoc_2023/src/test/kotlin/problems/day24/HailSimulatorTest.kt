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
//        assertEquals(
//            Hailstone(HailCoordinate(19, 13, 30), HailCoordinate(-2, 1, -2)),
//            hailSimulator.hailstones[0]
//        )
    }

    @Test
    fun intersectionsXY() {
        assertEquals(5, hailSimulator.intersectionsXY().size)
    }

    @Test
    fun intersectionsInArea() {
        assertEquals(2, hailSimulator.intersectionsIn2DArea(7.toBigDecimal(), 27.toBigDecimal()).size)
    }


    @Test
    fun firstPlane() {
        val plane = HailPlane(
            0.toBigDecimal(),
            (-8).toBigDecimal(),
            4.toBigDecimal(),
            64.toBigDecimal()
        )

        assertEquals(plane, hailSimulator.firstPlane())
    }

//    @Test
//    fun rockThrowPos() {
//        val expected = HailCoordinate(24.toBigDecimal(), 13.toBigDecimal(), 10.toBigDecimal())
//        assertEquals(expected, hailSimulator.rockThrown().pos)
//    }

//    @Test
//    fun rockThrownBruteForcing() {
//        val expected = HailCoordinate(24.toBigDecimal(), 13.toBigDecimal(), 10.toBigDecimal())
//        assertEquals(expected, hailSimulator.rockThrownBruteForcing()!!.pos)
//    }

    @Test
    fun rockThroughEquations() {
        val result = hailSimulator.resolveEquations()
        assertEquals(47, result!!.pos.total().toInt())
    }
}