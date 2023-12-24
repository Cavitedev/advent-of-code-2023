package problems.day24

class Hailstone(val pos: HailCoordinate, val vel: HailCoordinate) {

    override fun toString(): String {
        return "$pos @ $vel"
    }

    fun intersection2D(other: Hailstone): HailCoordinate? {
        if (this.vel.x / other.vel.x - this.vel.y / other.vel.y < 0.0001) {
            return null
        }


        val m1 = this.vel.y - other.vel.y * (this.vel.x / other.vel.x)
        val value = other.pos.y - this.pos.y + other.vel.y * (other.pos.x - this.pos.x)

        val actualM1 = value / m1
        val x = this.pos.x + this.vel.x * actualM1
        val y = this.pos.y + this.vel.y * actualM1


        return HailCoordinate(x, y, 0)

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Hailstone) return false

        if (pos != other.pos) return false
        if (vel != other.vel) return false

        return true
    }

    override fun hashCode(): Int {
        var result = pos.hashCode()
        result = 31 * result + vel.hashCode()
        return result
    }


}