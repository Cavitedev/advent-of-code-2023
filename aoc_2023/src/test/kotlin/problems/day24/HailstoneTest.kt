package problems.day24

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.MathContext

class HailstoneTest {

    val mathContext = MathContext(10)

    @Test
    fun intersection2D() {

        val a = Hailstone(
            HailCoordinate(
                19.toBigDecimal(mathContext),
                13.toBigDecimal(mathContext),
                30.toBigDecimal(mathContext)
            ), HailCoordinate(-2.toBigDecimal(mathContext), 1.toBigDecimal(mathContext), -2.toBigDecimal(mathContext))
        )
        val b = Hailstone(
            HailCoordinate(
                18.toBigDecimal(mathContext),
                19.toBigDecimal(mathContext),
                22.toBigDecimal(mathContext)
            ), HailCoordinate(-1.toBigDecimal(mathContext), -1.toBigDecimal(mathContext), -2.toBigDecimal(mathContext))
        )
        val expectedIntersection = HailCoordinate(
            14.33333.toBigDecimal(mathContext),
            15.33333.toBigDecimal(mathContext),
            0.toBigDecimal(mathContext)
        )

        assertEquals(expectedIntersection, a.intersection2D(b))
    }

    @Test
    fun intersection2D2() {

        val a = Hailstone(
            HailCoordinate(
                19.toBigDecimal(mathContext),
                13.toBigDecimal(mathContext),
                30.toBigDecimal(mathContext)
            ), HailCoordinate(-2.toBigDecimal(mathContext), 1.toBigDecimal(mathContext), -2.toBigDecimal(mathContext))
        )
        val b = Hailstone(
            HailCoordinate(
                20.toBigDecimal(mathContext),
                25.toBigDecimal(mathContext),
                34.toBigDecimal(mathContext)
            ), HailCoordinate(-2.toBigDecimal(mathContext), -2.toBigDecimal(mathContext), -4.toBigDecimal(mathContext))
        )
        val expectedIntersection = HailCoordinate(
            11.66667.toBigDecimal(mathContext),
            16.66667.toBigDecimal(mathContext),
            0.toBigDecimal(mathContext)
        )

        assertEquals(expectedIntersection, a.intersection2D(b))
    }

    @Test
    fun intersection2DParallel() {
        val a = Hailstone(
            HailCoordinate(
                18.toBigDecimal(mathContext),
                19.toBigDecimal(mathContext),
                22.toBigDecimal(mathContext)
            ), HailCoordinate(-1.toBigDecimal(mathContext), -1.toBigDecimal(mathContext), -2.toBigDecimal(mathContext))
        )
        val b = Hailstone(
            HailCoordinate(
                20.toBigDecimal(mathContext),
                25.toBigDecimal(mathContext),
                34.toBigDecimal(mathContext)
            ), HailCoordinate(-2.toBigDecimal(mathContext), -2.toBigDecimal(mathContext), -4.toBigDecimal(mathContext))
        )

        assertEquals(null, a.intersection2D(b))
    }
}