package problems.day24

import java.math.BigDecimal
import java.math.RoundingMode

class HailPlane(var a: BigDecimal, var b: BigDecimal, var c: BigDecimal, var d: BigDecimal) {

    init {
        val scale = 5
        a = a.setScale(scale, RoundingMode.HALF_UP)
        b = b.setScale(scale, RoundingMode.HALF_UP)
        c = c.setScale(scale, RoundingMode.HALF_UP)
        d = d.setScale(scale, RoundingMode.HALF_UP)
    }


    fun intersection(plane2: HailPlane, plane3: HailPlane): HailCoordinate {
        val plane1 = this

        val eqYZ1 = if (plane1.a.toDouble() == 0.0) plane1 else plane1.intersectA(plane2)
        val eqYZ2 = if (plane1.a.toDouble() == 0.0) plane2.intersectA(plane3) else plane1.intersectA(plane3)

        val eqZ = eqYZ1.intersectB(eqYZ2)
        val z = -eqZ.d / eqZ.c
        val y = -(eqYZ1.d + eqYZ1.c * z) / eqYZ1.b

        val planeWithX = listOf(plane1, plane2, plane3).find { it.a.toDouble() != 0.0 }!!

        val x = -(planeWithX.d + planeWithX.c * z + planeWithX.b * y) / planeWithX.a

        return HailCoordinate(x, y, z)
    }

    private fun intersectA(plane2: HailPlane): HailPlane {
        val plane1 = this
        val dif = -plane2.a / plane1.a
        // plane 1 * dif +  plane 2
        return plane1.multiply(dif).add(plane2)
    }

    private fun intersectB(plane2: HailPlane): HailPlane {
        val plane1 = this
        val dif = -plane2.b / plane1.b
        // plane 1 * dif +  plane 2
        return plane1.multiply(dif).add(plane2)
    }

    fun multiply(value: BigDecimal): HailPlane {
        return HailPlane(a * value, b * value, c * value, d * value)
    }

    fun add(other: HailPlane): HailPlane {
        return HailPlane(a + other.a, b + other.b, c + other.c, d + other.d)
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is HailPlane) return false

        if (a != other.a) return false
        if (b != other.b) return false
        if (c != other.c) return false
        if (d != other.d) return false

        return true
    }

    override fun hashCode(): Int {
        var result = a.hashCode()
        result = 31 * result + b.hashCode()
        result = 31 * result + c.hashCode()
        result = 31 * result + d.hashCode()
        return result
    }

    override fun toString(): String {
        return "$a*x + $b*y + $c*z +$d = 0"
    }


}