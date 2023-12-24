package problems.day24

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HailstoneTest {

    @Test
    fun intersection2D() {
        val a = Hailstone(HailCoordinate(19, 13, 30), HailCoordinate(-2, 1, -2))
        val b = Hailstone(HailCoordinate(18, 19, 22), HailCoordinate(-1, -1, -2))
        val expectedIntersection = HailCoordinate(14, 15, 0)

        assertEquals(expectedIntersection, a.intersection2D(b))
    }

    @Test
    fun intersection2DParallel() {
        val a = Hailstone(HailCoordinate(18, 19, 22), HailCoordinate(-1, -1, -2))
        val b = Hailstone(HailCoordinate(20, 25, 34), HailCoordinate(-2, -2, -4))

        assertEquals(null, a.intersection2D(b))
    }
}