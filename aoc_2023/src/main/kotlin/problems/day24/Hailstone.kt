package problems.day24

class Hailstone(val pos: HailCoordinate, val vel: HailCoordinate) {

    override fun toString(): String {
        return "$pos @ $vel"
    }

    fun intersectionXY(other: Hailstone): HailCoordinate? {
        if ((this.vel.x / other.vel.x - this.vel.y / other.vel.y).abs() < 0.0001.toBigDecimal()) {
            return null
        }


        val m1 = this.vel.y - other.vel.y * (this.vel.x / other.vel.x)
        val value = other.pos.y - this.pos.y + other.vel.y * ((other.pos.x - this.pos.x) / -other.vel.x)


        val actualM1 = value / m1
        if (actualM1 < 0.toBigDecimal()) {
            return null
        }
        val actualM2 = (this.pos.x - other.pos.x + this.vel.x * actualM1) / other.vel.x
        if (actualM2 < 0.toBigDecimal()) {
            return null
        }

        val x = this.pos.x + this.vel.x * actualM1
        val y = this.pos.y + this.vel.y * actualM1


        return HailCoordinate(x, y, 0.toBigDecimal())

    }

    fun planeParalelLines(other: Hailstone): HailPlane? {
        if ((this.vel.x / other.vel.x - this.vel.y / other.vel.y).abs() < 0.0001.toBigDecimal() &&
            (this.vel.x / other.vel.x - this.vel.z / other.vel.z).abs() < 0.0001.toBigDecimal()
        ) {
            // Paralel
            val p = this.pos
            val m1 = this.vel
            val m2 = this.pos.subtract(other.pos)

            val a = m1.y * m2.z - m1.z * m2.y
            val b = m1.z * m2.x - m1.x * m2.z
            val c = m1.x * m2.y - m1.y * m2.x
            val d = a * -p.x + b * -p.y + c * -p.z
            return HailPlane(a, b, c, d)

        }
        return null
    }

    fun toPlanes(): List<HailPlane> {

        val plane1 = HailPlane(
            this.vel.y,
            -this.vel.x,
            0.toBigDecimal(),
            -this.pos.x * this.vel.y - (-this.pos.y) * this.vel.x
        )

        val plane2 = HailPlane(
            this.vel.z,
            0.toBigDecimal(),
            -this.vel.x,
            -this.pos.x * this.vel.z - (-this.pos.z) * this.vel.x
        )

        return listOf(plane1, plane2)
    }


    override fun hashCode(): Int {
        var result = pos.hashCode()
        result = 31 * result + vel.hashCode()
        return result
    }


}