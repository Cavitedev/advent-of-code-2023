package problems.day24

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

class HailCoordinate(var x: BigDecimal, var y: BigDecimal, var z: BigDecimal) {

    init {
        val scale = 5
        x = x.setScale(scale, RoundingMode.HALF_UP)
        y = y.setScale(scale, RoundingMode.HALF_UP)
        z = z.setScale(scale, RoundingMode.HALF_UP)
    }

    fun roundedCoordinate(): HailCoordinate {
        val roundedX = (x.multiply(1000.toBigDecimal())).round(MathContext(128)) / 1000.0.toBigDecimal()
        val roundedY = (y.multiply(1000.toBigDecimal())).round(MathContext(128)) / 1000.0.toBigDecimal()
        val roundedZ = (z.multiply(1000.toBigDecimal())).round(MathContext(128)) / 1000.0.toBigDecimal()
        return HailCoordinate(roundedX, roundedY, roundedZ)
    }

    fun subtract(other: HailCoordinate): HailCoordinate {
        return HailCoordinate(this.x - other.x, this.y - other.y, this.z - other.z)
    }

    fun multiply(value: BigDecimal): HailCoordinate {
        return HailCoordinate(this.x * value, this.y * value, this.z * value)
    }

    fun total(): BigDecimal {
        return x + y + z
    }

    fun divide(other: HailCoordinate): HailCoordinate {
        return HailCoordinate(this.x / other.x, this.y / other.y, this.z / other.z)
    }

    override fun toString(): String {
        return "$x,$y,$z"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is HailCoordinate) return false

        if (x != other.x) return false
        if (y != other.y) return false
        if (z != other.z) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        return result
    }


}