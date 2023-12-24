package problems.day24

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.MathContext

class HailPlaneTest {

    val mathContext = MathContext(10)

    @Test
    fun intersection() {

        val plane1 = HailPlane(
            0.toBigDecimal(mathContext),
            (-8).toBigDecimal(mathContext),
            4.toBigDecimal(mathContext),
            64.toBigDecimal(mathContext)
        )

        val plane2 = HailPlane(
            1.toBigDecimal(mathContext),
            2.toBigDecimal(mathContext),
            0.toBigDecimal(mathContext),
            -45.toBigDecimal(mathContext)
        )
        val plane3 = HailPlane(
            -2.toBigDecimal(mathContext),
            0.toBigDecimal(mathContext),
            2.toBigDecimal(mathContext),
            -22.toBigDecimal(mathContext)
        )

        val intersection =
            HailCoordinate(9.toBigDecimal(mathContext), 18.toBigDecimal(mathContext), 20.toBigDecimal(mathContext))

        assertEquals(intersection, plane1.intersection(plane2, plane3))


    }
}